/**
 * @author Fumi Honda 108180831 This class implements Comparator<Adult>
 */
import java.util.Comparator;

public class EverythingComparator implements Comparator<Adult> {

    /**
     * @param o1 Adult
     * @param o2 Adult
     * @return int of whether greater(+), less(-) or equal(0)
     */
    public int compare(Adult o1, Adult o2) {
        int ageCompare = new Integer(o1.getAge()).compareTo(new Integer(o2.getAge()));
        int childProducedCompare = new Integer(o1.getLifetimeChildProduced()).compareTo(new Integer(o2.getLifetimeChildProduced()));
        int childGrownCompare = new Integer(o1.getLifetimeChildGrown()).compareTo(new Integer(o2.getLifetimeChildGrown()));
        if (ageCompare != 0) {
            return ageCompare;
        }
        if (childProducedCompare != 0) {
            return childProducedCompare;
        }
        if (childGrownCompare != 0) {
            return childGrownCompare;
        } 
        
        return 0; 
        
    }

}
