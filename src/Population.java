
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * @author Fumi Honda 108180831
 * This class holds an arraylist of Adult objects
 * the societalResource is for future implementation/development
 */
public class Population {

    Adult instAdult = new Adult();
    private int numPopulation;
    private double societalResource;
    
    private ArrayList<Adult> adultList;

    /**
     * The first half of adultList is riskAverse, second half is riskNeutral
     * Set their boolean riskAverse and betting probability accordingly
     * @param numPop int
     */
    public Population(int numPop) {
        this.numPopulation = numPop;
        adultList = new ArrayList<Adult>();
        this.societalResource = societalResource;
        
        for (int i = 0; i <numPopulation/2; i++) {
            Adult riskAverse = new Adult();
            riskAverse.setBetProb(SimulationGUI.averseBetProb);
            riskAverse.setRiskAverse(true);
            adultList.add(riskAverse);
        }

        for (int i = numPopulation/2; i <numPopulation; i++) {
            Adult riskNeutral = new Adult();
            riskNeutral.setBetProb(SimulationGUI.neutralBetProb);
            riskNeutral.setRiskAverse(false);
            adultList.add(riskNeutral);
        }
        
        System.out.println("adult list is of size" + adultList.size());

    }

    /**
     * getMethod
     * @return an ArrayList of Adult objects
     */
    public ArrayList<Adult> getAdultList() {
        return this.adultList;
    }
        
/**
 * sort the AgeComparatorObject
 */
    void sortAge() {
        Collections.sort(adultList, new AgeComparator());
                //the AgeComparator object is passed, default empty construtor, using that compareto method to sort the adultlist    
    }

    /**
     * sort the ChildProducedComparatorObject
     */
    void sortChildProduced(){
        Collections.sort(adultList, new ChildProducedComparator());
    }
    
    /**
     * sort the childGrownComparatorObject
     */
    void sortChildGrown(){
        Collections.sort(adultList, new ChildGrownComparator());
    }
    
    /**
     * sort the EverythingComparator object
     */
    void sortEverything(){
        Collections.sort(adultList, new EverythingComparator());
    }
    
    /**
     * 
     * @return String ageResult if using ageSort
     */
    String ageToString(){
        String ageResult = "";  //empty string may point to anywhere, not at memory address 0
        for(Adult output: adultList){
            ageResult +=output.getAge()+"  ";
        }
        return ageResult;  
    }
    
    /**
     * 
     * @return String childProducedString if using sortChildProduced
     */
    String childProducedToString(){
        String childProducedString = "";
        for(Adult output: adultList){
            childProducedString += output.getLifetimeChildProduced()+ "  ";
        }
        return childProducedString;
    }
    
    /** 
     * @return childGrownString if using sortChildGrown
     */
    String childGrownToString(){
        String childGrownString = "";
        for(Adult output: adultList){
            childGrownString += output.getLifetimeChildGrown()+ "  ";
        }
        return childGrownString;
    }
    
    /**
     * @return String adultString Age, # of childProduced, # of childGrown and whether they are RiskAverse
     */
    String adultToString(){
        String adultString = "\n" +"Age  #Produced  #Grown  RiskAverse?" + "\n";
        for(Adult output: adultList){
        adultString += output.getAge() + ",          "+ output.getLifetimeChildProduced() + ",               " + output.getLifetimeChildGrown() +"            "+output.getRiskAverse()+"\n";
        }
        return adultString;
    }
    

}
