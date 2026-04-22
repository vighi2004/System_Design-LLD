//studying strategic design patterns with example of robot and its functions.

interface  walkable{
    void walk();
}
class normalwalk implements walkable{
    @Override
    public void walk() {
        System.out.println("Walking normally.");
    }
}   
class nowalk implements walkable{
    @Override
    public void walk() {
        System.out.println("Cannot walk.");
    }
}

interface talkable{
    void talk();
}
class normaltalk implements talkable{
    @Override
    public void talk() {
        System.out.println("Talking normally.");
    }
}
class notalk implements talkable{
    @Override
    public void talk() {
        System.out.println("Cannot talk.");
    }
}

interface flyable{
    void fly();
}
class canfly implements flyable{
    @Override
    public void fly() {
        System.out.println("Flying.");
    }
}   
class cantfly implements flyable{
    @Override
    public void fly() {
        System.out.println("Cannot fly.");
    }
}
interface projectionable{
    void projection();
}
class canproject implements projectionable{
    @Override
    public void projection() {
        System.out.println("Projecting.");
    }
}
class cantproject implements projectionable{
    @Override
    public void projection() {
        System.out.println("Cannot project.");
    }
}

class Robot{
    private walkable walkBehavior;
    private talkable talkBehavior;
    private flyable flyBehavior;
    private projectionable projectionBehavior;

    public Robot(walkable walkBehavior, talkable talkBehavior, flyable flyBehavior, projectionable projectionBehavior) {
        this.walkBehavior = walkBehavior;
        this.talkBehavior = talkBehavior;
        this.flyBehavior = flyBehavior;
        this.projectionBehavior = projectionBehavior;
    }

    public void performWalk() {
        walkBehavior.walk();
    }

    public void performTalk() {
        talkBehavior.talk();
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void performProjection() {
        projectionBehavior.projection();
    }
}

public class strategicDesign {
    public static void main(String[] args) {
        Robot R1=new Robot(new nowalk(), new notalk(), new cantfly(), new cantproject());
        R1.performWalk();
        R1.performTalk();
        R1.performFly();
        R1.performProjection();

        Robot R2=new Robot(new normalwalk(), new normaltalk(), new canfly(), new canproject());
        R2.performWalk();   
        R2.performTalk();
        R2.performFly();
        R2.performProjection();
    }
}
