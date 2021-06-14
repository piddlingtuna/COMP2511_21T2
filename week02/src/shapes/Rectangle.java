package shapes;

public class Rectangle extends Shape { // inherits from shape
    public int height; // = 0; by default
    public int width; // = 0; by defaul
    public Shape shape; // = null;

    public Rectangle(String color) {
        // super(color);
        System.out.println("Inside Rectangle constructor with one argument");
    }
    
    // Rectange(3) -> Rectangle(1) -> Shape(1)

    public Rectangle(String color, int width, int height) {
        this(color);
        this.width = width;
        this.height = height;
        System.out.println("Inside Rectangle constructor with three arguments");
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle("red", 10, 20);
    }
}
