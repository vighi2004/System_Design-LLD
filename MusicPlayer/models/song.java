package MusicPlayer.models;

public class song {
    private String name;
    private  String artist;
    private String path;
    public song(String name,String artist,String path){
        this.name=name;
        this.artist=artist;
        this.path=path;
    }
    public String getTitle(){
        return name;
    }
    public String getArtist(){
        return  artist;
    }
    public String getFile(){
        return path;
    }
}
