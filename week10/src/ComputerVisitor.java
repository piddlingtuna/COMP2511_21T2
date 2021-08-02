
public class ComputerVisitor {

    public static void main(String[] args) {
        ComputerComponent computer = new Computer("Corelli", 500);
        ComputerComponent keyboard = new Keyboard("Mechanical keyboard");
        ComputerComponent mouse = new Mouse("Bluetooth mouse");
        ComputerVisitor visitor = new ComputerVisitor();

    /*
        computer.accept(visitor);
        visitor.validate();
        
        computer.accept(visitor);
        keyboard.accept(visitor);
        mouse.accept(visitor);
    */
    }

}