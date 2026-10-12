//studying  depnedency inversion principle
interface database{
    void save();
}
class SQLDB implements  database{
      public void save(){
        System.out.println("storing in sql databse!");
      }
}
class MONGODB implements  database{
    public void save(){
        System.out.println("storing in mongoDB databse!");
    }
}
class user{
    database db;
    public user(database d){
        db=d;
    }
    public void saveTo(){
        db.save();
    }
}
public class DependencyInversion {
    public static void main(String[] args) {
        user db1=new user(new MONGODB());
        db1.saveTo();
    }
}
