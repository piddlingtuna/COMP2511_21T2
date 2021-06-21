package unsw.training;

import java.time.LocalDate;
import java.util.List;

public class TrainingSystem {

    public List<Trainer> trainers;

    public LocalDate badbookTraining(String employee, List<LocalDate> availability) {
        for (Trainer trainer : trainers) {
            for (Seminar seminar : trainer.getSeminars()) {
                for (LocalDate available : availability) {
                    if (seminar.getStart().equals(available) &&
                            seminar.getAttendees().size() < 10) {
                        seminar.getAttendees().add(employee);
                        return available;
                    }
                }
            }
        }
        return null;
    }
    
    // trainer.getSeminar().getAttendees.getWHATEVER() // violate the principle
    // trainer.bookTraining() this is better
    
    /**
     * 
     * @param employee
     * @param availability
     * @return The date of the seminar if booking was successful, otherwise null
     */
    public LocalDate bookTraining(String employee, List<LocalDate> availability) {
        for (Trainer trainer : trainers) {
            LocalDate booked = trainer.book(employee, availability);
            if (booked != null) {
                return booked;
            }
        }
        return null;
    }
}
