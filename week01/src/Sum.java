/**
 * If your IDE is set up correctly, it will add the following lines automatically.
 */
import java.util.Scanner;
import java.util.Arrays;

public class Sum {
    public static void main(String[] args) {
        /**
         * new - This instantiates (i.e. creates) a Scanner object.
         * Java's garbage collection automatically frees the memory for us (unlike in C where we must manually free).
         * Scanner - This encapsulates I/O into an object.
         * System.in - This is equivalent to stdin in C. We are reading from the console.
         */
        Scanner scanner = new Scanner(System.in);
        /**
         * nextLine - This reads the a whole line of input (until '\n').
         * split(" ") - This splits a String into String[].
         */
        String[] numbers = scanner.nextLine().split(" ");

        /**
         * int - This is a primitive data type; it is not a class.
         */
        int sum = 0;
        /**
         * This is a for-each loop, which is similar to a Python style for loop.
         * This is not the same as a for loop in C (which Java also supports).
         */
        for (String number : numbers) {
            /**
             * Integer - Since int is not a class, this class has helpful methods to deal with ints.
             * parseInt - This a static method of the Integer class.
             * It converts a string into an int.
             */
            sum += Integer.parseInt(number);
        }
        System.out.println("The sum is " + sum);

        /**
         * This is beyond the scope of this tutorial.
         * It uses streams to sum in a functional style.
         * For the interested: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/Stream.html
         */
        System.out.println("The sum is " + Arrays.asList(numbers).stream()
                                                  .mapToInt(Integer::parseInt)
                                                  .sum());
        
        /**
         * close - This is a method of a Scanner object.
         * It frees I/O resources.
         * Java's garbage collection only manages memory, not other resources that I/O uses.
         */
        scanner.close();
    }
}
