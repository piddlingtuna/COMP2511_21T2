package employee;

public class Employee {
    // String == class
    // int == primitive type
    private String name;
    private double salary;
    
    /**
     * This represents a employee at UNSW.
     * @param name - first and last name
     * @param salary - includes cents
     */
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    /**
     * 
     * @return <b>name</b> of employee
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", salary=" + salary + "]";
    }
    
    public static void main(String args[]) {
        System.out.println(new Employee("name", 0.0));
    }
    
    
}
