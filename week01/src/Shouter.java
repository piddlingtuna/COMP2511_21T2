public class Shouter {

    /**
     * This is an attribute (i.e. a variable stored in an object).
     * Every Shouter object has a message attribute.
     * private - This attribute can only be accessed inside this class (i.e. inside this file).
     * Code in other files simply can't accessthe message of a Shouter object.
     * String - String is a class used to store text.
     * Each String object has some useful methods attached like toUpperCase().
     */
    private String message;

    /**
     * This is a 'constructor' of a Shouter object.
     * This code is called whenever you make a new Shouter object.
     * 
     * @param message
     */
    public Shouter(String message) {
        /**
         * Since there *is* a message parameter, 'this.message' *must* be used *with* 'this.' because there *is* ambiguity.
         * This sets the object's message attribute to the message parameter.
         */
        this.message = message;
    }

    /**
     * This is an object method known as a getter.
     * Getter methods allow for controlled using of a private attribute.
     * There is implicitly a Shouter object called 'this' argument passed to this method.
     * Since there is no message parameter or variable, 'this.message' can be used without 'this.' because there is no ambiguity.
     * This method was generated automatically using 'Source Action > Generate Getters and Setters' (right click on VSCode).
     */
    public String getMessage() {
        return message;
    }

    /**
     * This is an object method known as a setter.
     * Setter methods allow for controlled changing of a private attribute.
     * There is implicitly a Shouter object called 'this' argument passed to this method.
     * Since there *is* a message parameter, 'this.message' *must* be used *with* 'this.' because there *is* ambiguity.
     * This method was generated automatically using 'Source Action > Generate Getters and Setters' (right click on VSCode).
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Every class inherits from a base object class which has a 'toString' method.
     * This is overriding 'toString' method in the base object class.
     * @Override is a decorator that causes an error when placed above a method that is not actually overriding another method.
     * When an object is printed, it actually just calls the 'toString' method of the object.
     */
    @Override
    public String toString() {
      return "Shouter [message=" + message + "]";
    }

    public void shout() {
        System.out.println(message.toUpperCase());
    }

    public static void printSomething() {
        System.out.println("Something");
    }

    public void shoutAndPrintSmething() {
      /**
       * Since we are inside an object method, we can use 'shout()' rather than 'this.shout()'.
       * If this method is called in another class (i.e. another file), we must use 'this.printSomething()'.
       */
      shout();
      /**
       * Since this is a static method in the Shouter class, we can use 'printSomething()' rather than 'Shouter.printSomething()'.
       * If this method is called in another class (i.e. another file), we must use 'Shouter.printSomething()'.
       */
      printSomething();
    }

    public static void main(String[] args) {
        Shouter s = new Shouter("hi");
        System.out.println(s);

        /**
         * Since we are inside a static method, we must specify which object instance we are calling these methods on.
         */
        s.shout();
        s.shoutAndPrintSmething();
    }
}
