// studying concept of L that is liskov substitution principle in java.
abstract class account {
    protected int balance;
    public void deposit(int balance){
        System.out.println("your balance is "+balance);
    }
}
abstract class withdraw extends account{
    abstract void withdraw(int amount);
}   
class savings extends withdraw{
    @Override
    void withdraw(int amount){
        if(amount>balance)
        System.out.println("you can withdraw "+amount);
    }
}
class fixedDeposit extends account{
    void withdraw(int amount){
        System.out.println("you cannot withdraw from fixed deposit");
    }
}
public class L{
     public static void main(String[] args) {
        savings s =new savings();
        s.deposit(1000); 
        s.withdraw(500);
        fixedDeposit f=new fixedDeposit();  
        f.deposit(1000);
        f.withdraw(500); 
     }
}
