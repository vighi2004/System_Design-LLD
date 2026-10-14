//Studying about Command Design Pattern using example of remote controller smart home.

import java.util.ArrayList;

interface Icommand{
    void excute();
    void undo();
}
class Light{
    public void on(){
        System.out.println("Light is on!");
    }
    public void off(){
        System.out.println("Light is off!");
    }
}

class Fan{
    public void on(){
        System.out.println("Fan is on!");
    }
    public void off(){
        System.out.println("Fan is off!");
    }
}
class LightCommad implements Icommand{
    Light light;
    public LightCommad(Light light){
        this.light=light;
    }
    @Override 
    public void excute(){
        light.on();
    }
    @Override 
    public void undo(){
        light.off();
    }
}

class FanCommad implements Icommand{
    Fan fan;
    public FanCommad(Fan fan){
        this.fan=fan;
    }
    @Override 
    public void excute(){
        fan.on();
    }
    @Override 
    public void undo(){
        fan.off();
    }
}
class remote{
    ArrayList<Icommand> options=new ArrayList<>(); 
    ArrayList <Boolean> flag=new ArrayList<>();
     public void setCommands(Icommand cd){
          options.add(cd);
          flag.add(false);
     }

     public void press(int idx){
        if(idx>=0 && idx<options.size()){
            if(flag.get(idx)==false){
                options.get(idx).excute();
                flag.set(idx,true);
            }
            else{
                options.get(idx).undo();
                flag.set(idx,false);
            }
        }
        else{
            System.out.println("Remote do not assign this index: "+idx);
        }
     }

}

public class CommandDesign {
     public static void main(String[] args) {
        remote r=new remote();
        Light hallLight=new Light();
        Fan hallFan=new Fan();
        r.setCommands(new LightCommad(hallLight));
        r.setCommands(new FanCommad(hallFan));
        r.press(0);
        r.press(0);
        r.press(1);
        r.press(1);
        r.press(2);
     }    
}
