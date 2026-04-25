//Studying Factroy method 3rd type abstract factory method which is responsible for more that one product.
interface burger{
    void prepare();
}
class simpleBurger implements burger{
   @Override
    public void prepare(){
        System.out.println("Preparing simple burger with cheese and lettuce.");
    }

}
class standardBurger implements burger{
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
class deluxeBurger implements burger{
    @Override
     public void prepare(){
          System.out.println("Preparing deluxe burger with cheese, lettuce, tomato, onion and bacon.");
     }
}
interface garlicBread{
    void prepare();
}
class simpleGarlicBread implements garlicBread{
    @Override
     public void prepare(){
          System.out.println("Preparing simple garlic bread with butter and garlic.");
     }
}
class standardGarlicBread implements garlicBread{
    @Override
     public void prepare(){
          System.out.println("Preparing standard garlic bread with butter, garlic and parsley.");
     }
}
class deluxeGarlicBread implements garlicBread{
    @Override
     public void prepare(){
          System.out.println("Preparing deluxe garlic bread with butter, garlic, parsley and cheese.");
     }
}
class KingGarlicBread implements garlicBread{
    @Override
     public void prepare(){
          System.out.println("Preparing king garlic bread with butter, garlic, parsley, cheese and bacon.");
     }
}

interface burgerFactory{
    burger createBurger(String type);
    garlicBread createGarlicBread(String type);
}
class simpleFactory implements burgerFactory{
    @Override
    public burger createBurger(String type) {
        if(type.equalsIgnoreCase("simple")){
            return new simpleBurger();
        }else if(type.equalsIgnoreCase("standard")){
            return new standardBurger();
        }
        else{
            throw new IllegalArgumentException("Invalid burger type: " + type);
        }
    }

    @Override
    public garlicBread createGarlicBread(String type) {
        if (type.equalsIgnoreCase("simple")) {
            return new simpleGarlicBread();
        } else if (type.equalsIgnoreCase("standard")) {
            return new standardGarlicBread();
        } else {
            throw new IllegalArgumentException("Invalid garlic bread type: " + type);
        }
    }
}
class deluxeFactory implements burgerFactory{
    @Override
    public burger createBurger(String type) {
        if(type.equalsIgnoreCase("deluxe")){
            return new deluxeBurger();
        }else if(type.equalsIgnoreCase("king")){
            return new kingBurger();
        }
        else{
            throw new IllegalArgumentException("Invalid burger type: " + type);
        }
    }

    @Override
    public garlicBread createGarlicBread(String type) {
        if (type.equalsIgnoreCase("deluxe")) {
            return new deluxeGarlicBread();
        } else if (type.equalsIgnoreCase("king")) {
            return new KingGarlicBread();
        } else {
            throw new IllegalArgumentException("Invalid garlic bread type: " + type);
        }
    }
}
public class abstractFactoryMethod{
    public static void main(String[] args) {
        burgerFactory BF=new simpleFactory();
        burger myBurger=BF.createBurger("standard");
        garlicBread myGarlicBread=BF.createGarlicBread("standard");
        myBurger.prepare();
        myGarlicBread.prepare();
    }
}