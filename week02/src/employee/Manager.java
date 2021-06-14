package employee;

import java.time.LocalDate;

public class Manager extends Employee {
    private LocalDate hireDate;

    public Manager(String name, double salary, LocalDate hireDate) {
        super(name, salary);
        this.hireDate = hireDate; // immutable
    }

    public LocalDate getHireDate() {
        return hireDate;
    }
    
    @Override
    public String toString() {
        return super.toString() + " hireDate = " + this.hireDate;
    }

}
