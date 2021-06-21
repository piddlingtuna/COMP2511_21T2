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

    public List<Seminar> getSeminars() {
        return seminars;
    }
    
    public void addSeminar(Seminar seminar) {
        seminars.add(seminar);
    }
    
    public void removeSeminar(Seminar seminar) {
        seminars.remove(seminar);
    }
    
    public LocalDate book(String employee, List<LocalDate> availability) {
        for (Seminar seminar : seminars) {
            // seminar.getAttendees().add("what I want");
            // seminar.getAttendees().remove(SOMETHING);
            LocalDate booked = seminar.book(employee, availability);
            if (booked != null)
                return booked;
        }
        return null;
    }

}
