//Studying Factroy design 2nd method Factory Method.
interface burger{
    void prepare();
}
class SimpleBurger implements burger{
   @Override
    public void prepare(){
        System.out.println("Preparing simple burger with cheese and lettuce.");
    }

}
class StandarBurger implements burger{
   @Override
    public void prepare(){
        System.out.println("Preparing standard burger with cheese, lettuce, tomato and onion.");
    }
}
class kingBurger implements burger{
   @Override
    public void prepare(){
        System.out.println("Preparing king burger with cheese, lettuce, tomato, onion and bacon.");
    }
}
class StandardBasicBurger implements burger{
   @Override
    public void prepare(){
        System.out.println("Preparing standard basic burger with cheese, lettuce and tomato.");
    }
}
class StandardDeluxeBurger implements burger{
   @Override
    public void prepare(){
        System.out.println("Preparing standard deluxe burger with cheese, lettuce, tomato and onion.");
    }
}
interface BurgerFactory{
    burger createBurger(String type);
    
}
class SimpleBurgerFactory implements BurgerFactory{
    @Override
    public burger createBurger(String type) {
        if(type.equalsIgnoreCase("simple")){
            return new SimpleBurger();
        }else if(type.equalsIgnoreCase("standard")){
            return new StandarBurger();
        }else if(type.equalsIgnoreCase("king")){
            return new kingBurger();
        }else{
            throw new IllegalArgumentException("Invalid burger type: " + type);
        }
        
    }
}
class StandardBurgerFactory implements BurgerFactory{
    @Override
    public burger createBurger(String type) {
        if(type.equalsIgnoreCase("basic")){
            return new StandardBasicBurger();
        }else if(type.equalsIgnoreCase("deluxe")){
            return new StandardDeluxeBurger();
        }else{
            throw new IllegalArgumentException("Invalid burger type: " + type);
        }
    }
}
public class FactoryMethod {
    public static void main(String[] args) {
        BurgerFactory BF=new StandardBurgerFactory();
        burger myBurger=BF.createBurger("deluxe");
        myBurger.prepare(); 
    }
}