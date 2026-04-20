//studying Dependency inversion principle

interface Database {
   void saveUser();
}

class SQL implements Database {
    @Override
    public void saveUser() {
        System.out.println("User saved to SQL Server");
    }
}

class Mongo implements Database {
    @Override
    public void saveUser() {
        System.out.println("User saved to MongoDB");
    }   
}

class Client {
    private Database db;


    public Client(Database db) {
        this.db = db;
    }

    public void user() {
        db.saveUser();
    }
}

public class DIP {
    public static void main(String[] args) {
        
        Database myDb = new Mongo(); 
        
        Client c = new Client(myDb); 
        
        c.user();
    }
}