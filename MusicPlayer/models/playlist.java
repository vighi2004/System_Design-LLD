package MusicPlayer.models;
import java.util.*;
public class playlist {
    private String name;
    ArrayList<song> list=new ArrayList<>();
    public playlist(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public ArrayList<song> getList(){
        return list;
    }
    public int getSize(){
        return list.size();
    }
    public void addSong(song s){
      if(s==null){
        System.out.println("cannot add it!");
        return ;
      }
      else{
         list.add(s);
      }
    }
}
