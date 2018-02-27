/**
 * @author Fumi Honda 108180831 This class implements Comparator<Adult>
 */
import java.util.Comparator;

public class ChildProducedComparator implements Comparator<Adult> {

    /**
     * @param o1 Adult
     * @param o2 Adult
     * @return int of whether greater(+), less(-) or equal(0)
     */
    @Override
    public int compare(Adult o1, Adult o2) {
        return new Integer(o1.getLifetimeChildProduced()).compareTo(new Integer(o2.getLifetimeChildProduced()));
    }

}
