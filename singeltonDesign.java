//Implementing singelton design pattern here.
class Singelton{
   //we use volatile keyword beacuse it miht possible half initialized object to other thread and it will cause problem in multithreading environment. 
    private static volatile Singelton Instance =null;
    private Singelton(){
        System.out.println("Creating a new instance of Singelton class.");
    }
    //getters using
    //making thrad safe now using synchronized keyword.
    public static Singelton getInstance(){
        //we double check beacuse two thread can parallelly go throgh and make two new instance.
        if(Instance==null){
            synchronized(Singelton.class){
                if(Instance==null){
                    Instance=new Singelton();
                }
            }
        }
        return Instance;
    }
}
public class singeltonDesign{
    public static void main(String[] args) {
        Singelton S=Singelton.getInstance();
        Singelton S1=Singelton.getInstance();
        if(S==S1){
            System.out.println("Both S and S1 are the same instance.");
        }
        else{
            System.out.println("S and S1 are different instances.");
        }
    }
}
//there is also another method eager instance creation means Instance=new singelton();ans just when calling getInstance() 
// method we return that instance but it is not good because if we never call getInstance() method then it will create instance unnecessarily.