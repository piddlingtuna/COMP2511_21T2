package unsw.training;

import java.time.LocalDate;
import java.util.List;

public class TrainingSystem {

    public List<Trainer> trainers;

    /**
     * Try to booking training for an employee, given their availability.
     *
     * @param employee
     * @param availability
     * @return The date of their seminar if booking was successful, null there
     * are no empty slots in seminars on the day they are available.
     */
    public LocalDate bookTraining(String employee, List<LocalDate> availability) {
        for (Trainer trainer : trainers) {
            LocalDate booked = trainer.book(employee, availability);
            if (booked != null)
                return booked;
        }
        return null;
    }
}
