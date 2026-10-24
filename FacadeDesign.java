//studying facade design pattern.
class powerSupply{
    public void provide(){
        System.out.println("Providing power!....");
    }
}
class coolingSystem{
    public void cooling(){
        System.out.println("Fans stated cooling!...");
    }
}
class memory{
   public void test(){
    System.out.println("Memory intailize!....");
   }
}
class cpu{
    public void load(){
        System.out.println("CPu started to load!.....");
    }
}
class bios{
      cpu cp;
      memory m;
      public void boot(cpu cp,memory m){
        System.out.println("Calling boot!....");
        cp.load();
        m.test();
      }
}
class harddrive{
      public void spin(){
        System.out.println("Harddrive is spinning up!>....");
      }
}
class operatingsystem{
      public void work(){
        System.out.println(":OS started to work!....");
      }
}
class ComputerFacade{
    memory m;
    bios b;
    cpu cp;
    operatingsystem os;
    harddrive hd;
    coolingSystem cs;
    powerSupply power;
    public ComputerFacade(){
        this.m=new memory();
        this.b=new bios();
        this.cp=new cpu();
        this.os=new operatingsystem();
        this.hd=new harddrive();
        this.power=new powerSupply();
        this.cs=new coolingSystem();
        
    }
    public void start(){
        System.out.println("--Computer starting !...");
        b.boot(cp,m);
        hd.spin();
        os.work();
        cs.cooling();
        power.provide();
        System.out.println("all done ready to go!.....");
    }
}

public class FacadeDesign {
    public static void main(String[] args) {
        ComputerFacade CF=new ComputerFacade();
        CF.start();
    }
}
