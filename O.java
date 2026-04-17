// studying concept of O that is open close principle in java.
abstract class storage{
    abstract void save(String data);
}

class SQL extends storage{
    @Override
    void save(String data){
        System.out.println("save in SQL");
    }
}
class mongoDB extends storage{
    @Override
    void save(String data){
        System.out.println("save in mongoDB");
    }
}

class file extends storage{
    @Override
    void save(String data){
        System.out.println("save in file");
    }
}
class DataManage{
    private storage s;
    public DataManage(storage s){
        this.s=s;
    }
    public void saveData(String data){
        s.save(data);
    }
}
public class O {

   public static void main(String[] args) {
    DataManage dm=new DataManage(new mongoDB());
    dm.saveData("hello");
   }    
}
