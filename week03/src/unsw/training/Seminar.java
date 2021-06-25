package unsw.training;

import java.time.LocalDate;
import java.util.List;

/**
 * An in person all day seminar with a maximum of 10 attendees.
 *
 */
public class Seminar {
    private LocalDate start;

    private List<String> attendees;

    public LocalDate getStart() {
        return start;
    }

    /**
     * Try to book this seminar if it occurs on one of the available days and
     * isn't already full
     * @param employee
     * @param availability
     * @return The date of the seminar if booking was successful, null otherwise
     */
    public LocalDate book(String employee, List<LocalDate> availability) {
        for (LocalDate available : availability) {
            if (start.equals(available) &&
                    attendees.size() < 10) {
                attendees.add(employee);
                return available;
            }
        }
        return null;
    }
}
