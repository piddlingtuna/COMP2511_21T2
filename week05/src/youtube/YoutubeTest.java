package youtube;

public class YoutubeTest {
    public static void main(String[] args) {
        User tay = new User("Tay");

        User david = new User("David");
        tay.subscribe(david);

        User eric = new User("Eric");
        tay.subscribe(eric);

        User ingrid = new User("Ingrid");
        tay.subscribe(ingrid);

        tay.publishVideo("My new plant from ikea!!!", 120);

        Bot oliver = new Bot("Oliver");
        tay.subscribe(oliver);

        tay.publishVideo("I love java <3", 180);
    }
}
