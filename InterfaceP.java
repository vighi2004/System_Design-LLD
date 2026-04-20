//studying interface segregation principle rule.

interface AreaCalculatable {
    void area();
}

interface VolumeCalculatable {
    void volume();
}

// Square only cares about Area (ISP)
class Square implements AreaCalculatable {
    int side = 5;
    public void area() {
        System.out.println("Area: " + (side * side));
    }
}


class Cube implements AreaCalculatable, VolumeCalculatable {
    int side = 5;
    
    public void area() {
    
        System.out.println("Surface Area: " + (6 * side * side));
    }

    public void volume() {
        System.out.println("Volume: " + (side * side * side));
    }
}
public class InterfaceP{
    public static void main(String[] args) {
        Cube c=new Cube();
        c.area();
        c.volume();

    }
}