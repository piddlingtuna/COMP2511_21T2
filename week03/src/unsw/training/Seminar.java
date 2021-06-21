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

    public List<String> getAttendees() {
        return attendees;
    }
    
    public LocalDate book(String employee, List<LocalDate> availability) {
        
        if (attendees.size < 10) {
            // safe
        }
        return null;
    }

}
