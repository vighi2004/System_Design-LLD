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
    
}
class BankClient{
    private account a;
    public BankClient(account a){
        this.a=a;
    }  
    public void deposit(int balance){
        a.deposit(balance);
    } 

}
public class L{
     public static void main(String[] args) {
        BankClient bc=new BankClient(new savings());
        bc.deposit(1000);
        BankClient bc1=new BankClient(new fixedDeposit());
        bc1.deposit(500);
     }
}
