class car {
    String brand;
    String Typecar;

    // Parent constructor
    public car(String brand, String Typecar) {
        this.brand = brand;
        this.Typecar = Typecar;
    }

    public void Type(String name) {
        this.Typecar = name;
        System.out.println("car type is: " + this.Typecar);
    }

    public void startEng() {
        System.out.println("engine started:....");
    }
}

class manual extends car {
    // Fixed: Added a constructor that calls the parent constructor using super()
    public manual(String brand) {
        super(brand, "manual car"); 
    }
}

class electric extends car {
    int batteryLevel = 0;

    // Fixed: Added brand to constructor and called super()
    public electric(String brand, int batteryLevel) {
        super(brand, "electric car"); 
        this.batteryLevel = batteryLevel;
    }

    void battery() {
        this.batteryLevel = 100;
        System.out.println("fully charged");
    }
}

public class inherti {
    public static void main(String[] args) {
        // Example usage:
        manual myManualCar = new manual("Toyota");
        myManualCar.Type("manual car");
        myManualCar.startEng();

        System.out.println();

        electric myElectricCar = new electric("Tesla", 50);
        myElectricCar.battery();
        myElectricCar.Type("electric car");
    }    
}
