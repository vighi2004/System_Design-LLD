class sportscar {
    private boolean isEngOne; 
    private int currspeed;
    private int currgear;
    private String tyre;

    public sportscar(String car) {
        this.isEngOne = false;
        this.currspeed = 0;
        this.currgear = 0;
        this.tyre = "mrf";
    }

    public void makeEngone() {
        this.isEngOne = true;
        System.out.println("engine is on!");
    }

    public void currspeed() {
        if (this.isEngOne) { // Simplified: isEngOne == true is the same as just isEngOne
            this.currspeed += 10;
            System.out.println("current speed is " + this.currspeed + " km/h");
        } else {
            System.out.println("Engine is off! Cannot accelerate.");
        }
    }

    public void currgear() {
        if (this.isEngOne) {
            this.currgear += 1;
            System.out.println("current gear is " + this.currgear);
        }
    }

    public void gettyre() {
        if (this.isEngOne) {
            System.out.println("tyre name is " + this.tyre);
        }
    }

    public void settyre(String tyre) {
        if (this.isEngOne) {
            this.currspeed = 0; // Reset speed when changing tyres
            this.currgear = 0; // Reset gear when changing tyres
            this.isEngOne = false; // Turn off the engine when changing tyres
            this.tyre = tyre;
            System.out.println("new tyre is " + this.tyre);
        }
    }
}

public class encap {
    public static void main(String[] args) {
        sportscar car1 = new sportscar("ferrari");
        car1.makeEngone();
        car1.currspeed();
        car1.currgear();
        car1.gettyre();
        System.out.println("changing tyre...");
        car1.settyre("lav");
        car1.makeEngone(); // Need to turn the engine back on after changing tyres
        car1.currspeed();
        car1.currgear();
        car1.settyre("ceat");
    }
}
