package MusicPlayer.managers;
import java.util.HashMap;
import MusicPlayer.models.song;

import MusicPlayer.models.playlist ;
public class PlaylistManager {
    private static PlaylistManager instance;
    HashMap<String, playlist> map=new HashMap<>();
    public PlaylistManager(){

    }
    public static PlaylistManager getInstance(){
        if(instance!=null){
            instance=new PlaylistManager();
        }
        return instance;
    }
    public void createPlaylist(String name){
        if(map.containsKey(name)){
            throw new RuntimeException("playlist " + name+" already exist");
        }
        map.put(name,new playlist(name));
    }
    public void addSongToPlaylist(String name,song s){
         if (!map.containsKey(name)) {
            throw new RuntimeException("Playlist \"" + name+ "\" not found.");
        }
        map.get(name).addSong(s);
    }
    public playlist getPlaylist(String name) {
        if (!map.containsKey(name)) {
            throw new RuntimeException("Playlist \"" + name + "\" not found.");
        }
        return map.get(name);
    }

}
