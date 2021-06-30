package youtube;

public class Bot implements Subscriber {
    private String nickname;

    public Bot(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public void notify(Video video) {
        System.out.println("Hello! I am a bot named " + nickname + " and I shall boost your view count.");
    }
}
