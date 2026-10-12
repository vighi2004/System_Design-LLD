//studying exmaple of Decoratr design of Mario game.
interface Character{
    String getAbilities();
}
class mario implements  Character{
     @Override   
     public String getAbilities(){
         return "I am Mario";
       }
}
class Decorator implements Character{
    Character ch;
    public Decorator(Character ch){
        this.ch=ch;
    }
    @Override 
    public String getAbilities(){
        return "ready!";
    }
}

class height extends Decorator{
    public height(Character ch){
        super(ch);
    }
    @Override 
    public String getAbilities(){
        return ch.getAbilities() +" with height up";
    } 
}
class speed extends Decorator{
    public speed(Character ch){
        super(ch);
    }
    @Override 
    public String getAbilities(){
        return ch.getAbilities() +" with speed up";
    } 
}
class power extends Decorator{
    public power(Character ch){
        super(ch);
    }
    @Override 
    public String getAbilities(){
        return ch.getAbilities() +" with power up";
    } 
}
public class DecoratorDesign {
    public static void main(String[] args) {
       Character mario=new mario();
       System.out.println("original:"+mario.getAbilities());
       mario=new height(mario);
       System.out.println("after h:"+mario.getAbilities());
       mario=new speed(mario);
       System.out.println("after s:"+mario.getAbilities());
       mario=new power(mario);
       System.out.println("after p:"+mario.getAbilities());

     
       
          
    }
}
