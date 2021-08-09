public class Keyboard implements ComputerComponent {

    private String name;
    private int numKeys = 36;

    public Keyboard(String name) {
        this.name = name;
    }
    
    public int getNumKeys() {
        return numKeys;
    }

    public void setNumKeys(int numKeys) {
        this.numKeys = numKeys;
    }

    @Override
    public String toString() {
        return name;
    }
    
    @Override
    public void accept(ComputerVisitor visitor) {
        // Actually uses `public void visit(Keyboard keyboard)`
        // Example of overloading
        visitor.visit(this);
    }
    
}
