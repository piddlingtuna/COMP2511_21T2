public class ConcreteComputerVisitor implements ComputerVisitor {

    private boolean validated = false;

    @Override
    public void validate() {
        validated = true;
    }

    /*
    Without the vistor pattern, this class would look like:
    public void visit(ComputerComponent component) {
        if (component instanceof Computer) {
            // do something
        } else if (component instanceof Keyboard) {
            // do something
        } else if (component instanceof Mouse) {
            // do something
        }
        // Add more if statements for every new `ComputerComponent`.
    }
    */

    @Override
    public void visit(Computer computer) {
        if (validated) {
            System.out.println("Looking at computer " + computer + " with memory " + computer.getMemory() + " GB.");
        }
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("Looking at keyboard " + keyboard + " keyboard which has " + keyboard.getNumKeys() + " keys.");   
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("Looking at my mouse " + mouse + ".");
        
    }
    
    public static void main(String[] args) {
        ComputerComponent computer = new Computer("Corelli", 500);
        ComputerComponent keyboard = new Keyboard("Mechanical keyboard");
        ComputerComponent mouse = new Mouse("Bluetooth mouse");

        ComputerVisitor visitor = new ConcreteComputerVisitor();

        computer.accept(visitor);
        visitor.validate();
        
        computer.accept(visitor);
        keyboard.accept(visitor);
        mouse.accept(visitor);
    }
}
