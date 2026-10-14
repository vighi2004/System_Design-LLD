//studying Adapter Design pattern using example client report conversion xml to json.
interface Ireport{
    String getJsonData(String data);
}
class XMLDataProvider{
    public String getXMLData(String data){
        return "Your XML data is provided for: "+data;
    }
}
class XMLDataAdapter implements Ireport{
    XMLDataProvider xpo;
    public XMLDataAdapter(XMLDataProvider xpo){
        this.xpo=xpo;
    }
    String res="";
    @Override 
    public String  getJsonData(String data){
       res=xpo.getXMLData(data);
       return "Your json data converted it is here :-> "+res;
    }
}
class client{
    public void get(Ireport rep, String data){
           System.out.println(rep.getJsonData(data));
    }
}
public class AdapterDesign {
    public static void main(String[] args) {
        XMLDataProvider xpo=new XMLDataProvider();
        XMLDataAdapter xda=new XMLDataAdapter(xpo);
        String data="vighnesh :22";
        client c=new client();
        c.get(xda, data);

    }
}
