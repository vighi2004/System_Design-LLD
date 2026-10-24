package MusicPlayer.device;

import MusicPlayer.external.HeadphonesApi;
import MusicPlayer.models.song;
public class HeadphonesAdapter implements IAudioOutputDevice {
    private HeadphonesApi api;
    public HeadphonesAdapter(HeadphonesApi api){
        this.api=api;
    }
    @Override 
    public void playAudio(song s){
        String data=s.getTitle() +" by "+s.getArtist();
        api.playSound(data);
    }
}
