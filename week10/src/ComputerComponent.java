public interface ComputerComponent {

    /**
     * Accepts a visistor.
     * @param visitor
     */
    public void accept(ComputerVisitor visitor);

}
