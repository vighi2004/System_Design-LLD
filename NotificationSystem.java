import java.util.*;
//Designing Notification Engine.

//first let make notification and decorator.
interface INotification{
   String getContent();
}
class SimpleNotification implements INotification{
   private String text;
   public SimpleNotification(String text){
    this.text=text;
   }
   @Override 
   public String getContent(){
    return text;
   }
}
class  NotifyDecorator implements INotification{
   INotification notification;
   public NotifyDecorator(INotification notification){
       this.notification=notification;
   }
   @Override 
   public String getContent(){
         return "hello";
}
}
class TimestampDecorator extends NotifyDecorator{
    TimestampDecorator(INotification n){
        super(n);
    }
    @Override 
    public String getContent(){
        return "[5pm ,date=10/10/2026]"+notification.getContent();
    }
}
class SignatureDecorator extends NotifyDecorator{
    private String sign;
    SignatureDecorator(String sign,INotification n){
        super(n);
        this.sign=sign;
    }
    @Override 
    public String getContent(){
        return notification.getContent()+"\n--" + sign+"\n\n";
    }
}

//Observer Pattern lets do it.

interface Iobserver{
     void update();
}
interface Iobservable{
    void add(Iobserver io);
    void remove(Iobserver io);
    void notifyObservers();
}
class NotificationObservable implements Iobservable{
     private Set<Iobserver> ObserverSet = new HashSet<>();     
     INotification currentNotification;
     @Override
     public void add(Iobserver io){
        ObserverSet.add(io);
     } 
     @Override 
     public void remove(Iobserver io){
        ObserverSet.remove(io);
     }
     @Override 
    public  void notifyObservers(){
        for (Iobserver sub : ObserverSet) {
            sub.update();
        }
     }
     void setNotification(INotification notification){
             this.currentNotification=notification;
             notifyObservers();
     }
     INotification getNotification(){
         return currentNotification;
     }
     String getNotificationContent(){
        return currentNotification.getContent();
     }
}
class logger implements Iobserver{
    NotificationObservable notificationObservable;
    public logger(NotificationObservable observable){
        this.notificationObservable=observable;
    }
    @Override 
    public void update(){
      System.out.println("Logging new notification:"+notificationObservable.getNotificationContent());
    }
}

//Stategy Pattern now..Notification Strategies
interface InotificationStrategy{
     void sendNotification(String content);
}
class EmailStrategy implements InotificationStrategy{
    String emailId;
    public EmailStrategy(String mail){
        this.emailId=mail;
    }
    @Override 
    public void sendNotification(String content){
        System.out.println("sending notification through email:"+emailId+" and " +"content is:"+content);
    }
}
class SMsStrategy implements InotificationStrategy{
    int phone;
    public SMsStrategy(int  num){
        this.phone=num;
    }
    @Override 
    public void sendNotification(String content){
        System.out.println("sending notification through SMS:"+phone+" and " +"content is:"+content);
    }
}
class NotificationEngine implements Iobserver{
     NotificationObservable notificationObservable;
     HashSet<InotificationStrategy> EngineSet=new HashSet<>();

     public NotificationEngine(NotificationObservable observable){
        this.notificationObservable=observable;
     }
     void addNotification(InotificationStrategy ns){
        EngineSet.add(ns);
     }
     @Override 
     public void update(){
        String content=notificationObservable.getNotificationContent();
        for (InotificationStrategy sub : EngineSet) {
            sub.sendNotification(content);
        }
     }
}

//Notification service creating singelton
class NotificationService{
    private NotificationObservable observable;
    private static  NotificationService instance;
    HashSet<INotification> notifications=new HashSet<>();
    NotificationService(){
        observable=new NotificationObservable();
    }
    public  static NotificationService getInstance(){
        if(instance==null){
            instance=new NotificationService();
        }
        return instance;
    } 
    NotificationObservable getObservable(){
        return observable;
    }

    void sendNotification(INotification notification){
        notifications.add(notification);
        observable.setNotification(notification);
    }


}
public class NotificationSystem {
    public static void main(String[] args) {
        NotificationService NS=NotificationService.getInstance();
        NotificationObservable NO=NS.getObservable();
        logger log=new logger(NO);
        NotificationEngine eng=new NotificationEngine(NO);
        eng.addNotification(new EmailStrategy("vighnesh4@gmail.com"));
        eng.addNotification(new SMsStrategy(91273738));
        NO.add(log);
        NO.add(eng);
        //decorators
        INotification note=new SimpleNotification("Your order is shipped!");
        note=new TimestampDecorator(note);
        note=new SignatureDecorator("customer care", note);
        NS.sendNotification(note);

    }
}
