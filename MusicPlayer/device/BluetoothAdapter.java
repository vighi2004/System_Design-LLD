package MusicPlayer.device;

import MusicPlayer.external.BluetoothApi;
import MusicPlayer.models.song;
public class BluetoothAdapter implements IAudioOutputDevice {
    private BluetoothApi api;
    public BluetoothAdapter(BluetoothApi api){
        this.api=api;
    }
    @Override 
    public void playAudio(song s){
        String data=s.getTitle() +" by "+s.getArtist();
        api.playSound(data);
    }
}