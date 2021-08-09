public interface ComputerVisitor {

    /**
     * Validate the visitor
     */
    public void validate();

    public void visit(Computer computer);

    public void visit(Keyboard keyboard);

    public void visit(Mouse mouse);

}
