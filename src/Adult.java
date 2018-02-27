
/**
 * @author Fumi Honda 108180831 This class holds an ArrayList of child objects
 */
import java.util.ArrayList;

public class Adult {

    private int lifetimeChildProduced;
    private int lifetimeChildGrown;
    private int age;
    private boolean ofAge;
    private boolean alive; //false after age>=50
    private double money;
    private boolean riskAverse;
    private double betProb;
    private ArrayList<Child> childList;

    /**
     * Adult constructor, holds empty Child ArrayList initially
     */
    public Adult() {
        ofAge = true;
        alive = true;
        age = 15;
        childList = new ArrayList<Child>();
        betProb = (riskAverse) ? 1.0 : 0.7;
    }

    /**
     * get method for childList
     *
     * @return
     */
    ArrayList<Child> getChildList() {
        return this.childList;
    }

    /**
     * First decides whether it will be based on the betProb assoicated with the
     * adult If will bet, decide whether will win by flipping coin
     */
    void bet() {
        boolean willBet = ((Math.random()) < betProb);  //is 1+ needed?
        if (willBet) {
            boolean hasWon = (((Math.random()) < 0.5));
            if (hasWon) {
                money += 5;
            } else {
                money -= 1.0;
            }
        }
    }

    /**
     * substracts surviveMoney needed from the amount of money adult has
     *
     * @param surviveMoney
     */
    void feedSelf(double surviveMoney) {

        if (money < surviveMoney) {
            alive = false;
        }

        money -= surviveMoney;
    }

    /**
     * goes through the childList and only feed the ones alive and underage,
     * cost $1 each
     */
    void feedChild() {
        for (Child childLiving : childList) {
            if (childLiving.isAlive() && !childLiving.isOfAge()) {
                if (money < 1) {
                    childLiving.setDead();
                }
                this.money -= 1;
            }
        }
    }

    /**
     * setRiskAverse
     *
     * @param riskAverse boolean
     */
    void setRiskAverse(boolean riskAverse) {
        this.riskAverse = riskAverse;
    }

    /**
     * get method
     *
     * @return
     */
    boolean getRiskAverse() {
        return this.riskAverse;
    }

    /**
     * optional set method
     *
     * @param betProb double
     */
    void setBetProb(double betProb) {
        this.betProb = betProb;
    }

    /**
     * set method on alive field to false
     */
    void setDead() {
        alive = false;
    }

    /**
     * @return alive boolean
     */
    boolean isAlive() {
        return alive;
    }

    /**
     * set method
     *
     * @param money double
     */
    void setMoney(double money) {
        this.money = money;
    }

    /**
     * loseMoney
     *
     * @param money double
     */
    void loseMoney(double money) {
        this.money -= money;
    }

    /**
     * @return hasMoney double
     */
    double hasMoney() {
        return money;
    }

    /**
     * Increase lifetimeChildProduced if money is more than $15 and allows new
     * Adult be added to the population
     */
    void reproduction() {
        if (money > 15) {
            money -= 15;
            Child newChild = new Child();
            childList.add(newChild);
            lifetimeChildProduced++;
        }
    }

    /**
     * @return int LifetimeChildProduced
     */
    int getLifetimeChildProduced() {
        return this.lifetimeChildProduced;
    }

    /**
     *
     * @return int LifetimeChildGrown
     */
    int getLifetimeChildGrown() {
        return this.lifetimeChildGrown;
    }

    /**
     * increase lifetimeChildGrown
     */
    void addLifetimeChildGrown() {
        lifetimeChildGrown++;
    }

    /**
     * @return int age
     */
    public int getAge() {
        return this.age;
    }

    /**
     * increase age if alive
     */
    void addAge() {
        if (isAlive()) {
            age += 1;
        }
    }

    /**
     * @return String childOutpout
     */
    String childListString() {
        String childOutput = "[";
        for (Child output : childList) {
            childOutput += output.getAge() + " ";
        }
        childOutput += "]";
        return childOutput;
    }

}
