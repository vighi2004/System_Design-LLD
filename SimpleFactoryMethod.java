//Studing Factory design patterns with first type Simple Factory where will look example of product burger.
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
class BurgerFcatory{
    public static burger createBurger(String type){
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
public class SimpleFactoryMethod{
    public static void main(String[] args) {
        String type="kig";
        BurgerFcatory bf=new BurgerFcatory();
        burger myBurger=bf.createBurger(type);
        myBurger.prepare();
    }
}