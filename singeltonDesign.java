//Implementing singelton design pattern here.
class Singelton{
    private static Singelton Instance =null;
    private Singelton(){
        System.out.println("Creating a new instance of Singelton class.");
    }
    //getters using
    //making thrad safe now using synchronized keyword.
    public static  synchronized Singelton getInstance(){
        if(Instance==null){
            Instance=new Singelton();
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