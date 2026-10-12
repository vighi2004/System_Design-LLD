import java.util.*;

// Interface methods must be implemented as public
interface Subscriber {
    void update();
}

interface Channel {
    void subscribe(Subscriber subs);
    void unsubscribe(Subscriber unsubs);
    void notifySubscribers(); // Renamed to avoid collision with Object.notify()
}

class ConcChannel implements Channel {
    // Set to store subscribers
    private Set<Subscriber> subset = new HashSet<>();
    private String name;
    private String latestVideo;

    public ConcChannel(String name) {
        this.name = name;
    }

    @Override
    public void subscribe(Subscriber sub) {
        subset.add(sub); // HashSet automatically handles duplicates
    }

    @Override
    public void unsubscribe(Subscriber sub) {
        subset.remove(sub);
    }

    @Override
    public void notifySubscribers() {
        // Fixed: HashSet must be iterated using an enhanced for-loop
        for (Subscriber sub : subset) {
            sub.update();
        }
    }

    public void upload(String title) {
        this.latestVideo = title;
        System.out.println("Latest video uploaded on channel: " + name);
        notifySubscribers();
    }

    // Fixed: Return String so it can be used in print statements
    public String getLatestVideo() {
        return latestVideo;
    }
}

class ConcSubscribe implements Subscriber {
    private String name;
    private ConcChannel channel;

    public ConcSubscribe(String name, ConcChannel channel) {
        this.name = name;
        this.channel = channel;
    }

    @Override
    public void update() {
        // Fixed: Replaced commas with '+' for proper Java string concatenation
        System.out.println("Hey " + name + ", channel uploaded a new video: " + channel.getLatestVideo());
    }
} 

public class ObserveDesign {
    public static void main(String[] args) {
        ConcChannel ch = new ConcChannel("Bluestorm");
        ConcSubscribe sub = new ConcSubscribe("vighnesh", ch);
        ConcSubscribe sub1 = new ConcSubscribe("kunal", ch);
        
        ch.subscribe(sub);
        ch.subscribe(sub1);
        ch.unsubscribe(sub1);
        // Simulating video upload (this automatically notifies the subscriber)
        ch.upload("Bgmi live 1V4");
    }
}
