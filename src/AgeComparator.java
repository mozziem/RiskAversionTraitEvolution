/**
 * @author Fumi Honda 108180831 This class implements Comparator<Adult>
 */
import java.util.Comparator;

public class AgeComparator implements Comparator<Adult>{
    
    /**
     * @param o1 Adult
     * @param o2 Adult
     * @return int of whether greater(+), less(-) or equal(0)
     */
   @Override
    public int compare(Adult o1, Adult o2){
        /*
      if(o1.getAge()>o2.getAge()){
          return 1;
      }
      if(o1.getAge()<o2.getAge()){
          return -1;
      }
      else return 0;
     */
        
        //compareTo is inside the Integer wrapper class but not in primitive integer class
        //it also requires the object be instantiated, so new Integer...
    return new Integer(o1.getAge()).compareTo(new Integer(o2.getAge())); 
          
    }
    
    /**
    public boolean equals(Object o){
        return true;
    }
    */
    
}
