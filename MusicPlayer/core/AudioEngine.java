package MusicPlayer.core;
import MusicPlayer.models.song;
import MusicPlayer.device.IAudioOutputDevice;
public class AudioEngine {
    private song current;
    private boolean isPaused;
    public AudioEngine(){
          current=null;
          isPaused=false;
    }
    public String getCurrentSongTitle(){
        if(current!=null){
            return current.getTitle();
        }
        return "";
    }
    public boolean isPause(){
        return  isPaused;
    }
    public void play(IAudioOutputDevice aod,song s){
        if(s==null){
           throw new Error("no song found!!!");
        }
        if(isPaused && s==current){
              isPaused=false;
              System.out.println("Resuming song "+s.getTitle());
              aod.playAudio(s);
              return;
        }
    }
    public void pause(){
        if(current==null){
            throw new Error("no song found!!!");
        }
        if(isPaused){
            throw new Error("song is already paused!!!");
        }
        isPaused=true;
        System.out.println("song paused .. "+current.getTitle());
    }
}
