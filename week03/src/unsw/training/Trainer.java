package unsw.training;

import java.time.LocalDate;
import java.util.List;

/**
 * A trainer that runs in person seminars.
 *
 */
public class Trainer {

    private String name;
    private String room;

    private List<Seminar> seminars;

    /**
     * Try to book one of this trainer's seminars.
     * @param employee
     * @param availability
     * @return The date of the seminar if booking was successful, null if the
     * trainer has no free slots in seminars on the available days.
     */
    public LocalDate book(String employee, List<LocalDate> availability) {
        for (Seminar seminar : seminars) {
            LocalDate booked = seminar.book(employee, availability);
            if (booked != null)
                return booked;
        }
        return null;
    }
}
