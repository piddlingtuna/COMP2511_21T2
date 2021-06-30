package youtube;

import java.util.ArrayList;
import java.util.List;

public class User implements Subscriber {
    private String name;
    private List<Subscriber> subscribers = new ArrayList<Subscriber>();

    public User(String name) {
        this.name = name;
    }

    @Override
    public void notify(Video video) {
        System.out.println("Hi " + name + ", a new video has been released called " + video.getTitle() +  " from  " + video.getProducerName() + "!");
    }

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void publishVideo(String title, int length) {
        Video video = new Video(this, title, length);
        for (Subscriber subscriber : subscribers) {
            subscriber.notify(video);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
