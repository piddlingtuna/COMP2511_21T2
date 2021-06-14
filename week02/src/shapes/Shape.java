package shapes;

public class Shape {
    public String color;
    
    public Shape() {
    }

    public Shape(String color) {
        // super();
        System.out.println("Inside Shape constructor");
        this.color = color;
    }
}
