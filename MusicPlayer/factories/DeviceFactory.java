package MusicPlayer.factories;

import MusicPlayer.device.IAudioOutputDevice;
import MusicPlayer.device.BluetoothAdapter;
import MusicPlayer.device.HeadphonesAdapter;
import MusicPlayer.device.WiredAdapter;
import MusicPlayer.external.BluetoothApi;
import MusicPlayer.external.HeadphonesApi;
import MusicPlayer.external.WiredApi;
import MusicPlayer.enums.DeviceType;


public class DeviceFactory {
    public static IAudioOutputDevice createDevice(DeviceType deviceType) {
        switch (deviceType) {
            case BLUETOOTH:
                return new BluetoothAdapter(new BluetoothApi());
            case WIRED:
                return new WiredAdapter(new WiredApi());
            case HEADPHONES:
            default:
                return new HeadphonesAdapter(new HeadphonesApi());
        }
    }
}
