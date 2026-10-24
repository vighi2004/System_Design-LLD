package MusicPlayer.managers;
import MusicPlayer.device.IAudioOutputDevice;
import MusicPlayer.enums.DeviceType;
import MusicPlayer.factories.DeviceFactory;
public class DeviceManager {
    private IAudioOutputDevice aod;
    private static DeviceManager instance;
    public DeviceManager(){
        aod=null;
    }
    public static DeviceManager getInstance(){
        if(instance==null){
            instance=new DeviceManager();
        }
        return instance;
    }
    public void connect(DeviceType dt){
        if(aod!=null){

        }
        aod=DeviceFactory.createDevice(dt);
        switch (dt) {
            case BLUETOOTH:
                System.out.println("Bluetooth device connected ");
                break;
            case WIRED:
                System.out.println("Wired device connected ");
                break;
            case HEADPHONES:
                System.out.println("Headphones connected ");
                break;
        }
    }
    public IAudioOutputDevice getOutputDevice() {
        if (aod == null) {
            throw new RuntimeException("No output device is connected.");
        }
        return aod;
    }

    public boolean hasOutputDevice() {
        return aod!= null;
    }
}
