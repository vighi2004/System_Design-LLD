package MusicPlayer.device;


import MusicPlayer.external.WiredApi;
import MusicPlayer.models.song;
public class WiredAdapter implements IAudioOutputDevice {
    private WiredApi api;
    public WiredAdapter(WiredApi api){
        this.api=api;
    }
    @Override 
    public void playAudio(song s){
        String data=s.getTitle() +" by "+s.getArtist();
        api.playSound(data);
    }
}
