package youtube;

public class Video {
    private String title;
    private User producer;
    private int length;
    private int likes = 0;
    private int dislikes = 0;

    public Video(User producer, String title, int length) {
        this.producer = producer;
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public User getProducer() {
        return producer;
    }

    public String getProducerName() {
        return producer.getName();
    }

    public int getLength() {
        return length;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void addLike() {
        likes++;
    }

    public void subtractLike() {
        likes--;
    }

    public void addDislike() {
        dislikes++;
    }

    public void subtractDislike() {
        dislikes--;
    }
}
