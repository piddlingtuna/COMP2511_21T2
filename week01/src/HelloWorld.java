/**
 * public - This class is accessible from any other class.
 * class - This is a blueprint for an object.
 * An object is similar to a struct in C associated with functions (called methods in Java).
 * HelloWorld - The name of the class. The file must have the same name (i.e. it must be called HelloWorld.java).
 *
 */
public class HelloWorld {

    /**
     * public - This method can be called from any other class.
     * In Java, a main function must be public to run.
     * static - This can be called without instantiating (i.e. creating) an object of this class.
     * void - This function does not return (unlike main in C).
     * String[] args - This is equivalent to int argc and char *argv  in C.
     * Because arrays have a length attribute in Java, int argc is not necessary.
     */
    public static void main(String[] args) {
        /**
         * System.out - This is equivalent to stdout in C.
         * System.in - This is equivalent to stdin in C.
         * println - This is a method on the System.out object.
         */
        System.out.println("Hello, World!");
    }

}
