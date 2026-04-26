//Implementing singelton design pattern here.
class Singelton{
    public Singelton(){
        System.out.println("Creating a new instance of Singelton class.");
    }
}
public class singeltonDesign{
    public static void main(String[] args) {
        Singelton S=new Singelton();
        Singelton S1=new Singelton();
        if(S==S1){
            System.out.println("Both S and S1 are the same instance.");
        }
        else{
            System.out.println("S and S1 are different instances.");
        }
    }
}