
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author miumermaid
 */
public class Simulation {

    static double averseBetProb = .7;
    static double neutralBetProb = 1.0;
    static Population thePop;
    static int numPopulation;
    static int riskAversePopCount = 0;   // numPopulation / 2;
    static int riskNeutralPopCount = 0;  //  numPopulation / 2;
    static double socResource;
    static double moneyEarned;
    static int dyingAge = 50;
    static int comingOfAge = 15;
    static double surviveMoney;

    public static void oldmain(String[] args) {

        Scanner stdin = new Scanner(System.in);
        System.out.println("Input duration");
        int duration = stdin.nextInt();
        System.out.println("Input even numPopulation");
        numPopulation = stdin.nextInt();
        //System.out.println("Input societal resource $ amount");
        //socResource = stdin.nextDouble();
        System.out.println("Input money earned per second");
        moneyEarned = stdin.nextDouble();
        System.out.println("Input survival amount $ needed");
        surviveMoney = stdin.nextDouble();

        thePop = new Population(numPopulation);

        simulate(duration);
        populationTally();        
        System.out.println("\n" + "~~~RiskAversePopCount " + riskAversePopCount + ", RiskNeutralPopCount " + riskNeutralPopCount + "~~~");

        thePop.sortEverything();
        System.out.println(thePop.adultToString());

        /**
         * thePop.sortAge();
         * System.out.println(thePop.getAdultList().get(0).getAge());
         * System.out.println(thePop.ageToString()); thePop.sortChildProduced();
         * System.out.println(thePop.childProducedToString());
         * thePop.sortChildGrown();
         * System.out.println(thePop.childGrownToString()); //child
         *
         */
    }

    /**
     * Both adult and child checks their age first before performing actions
     * after actions, update age After
     *
     * @param duration
     */
    public static void simulate(int duration) { //return Population?
        int time = 1;

        while (duration >= 0) {

            System.out.println("\n" + "Time" + time);

            for (int i = 0; i < thePop.getAdultList().size(); i++) {
                Adult anAdult = thePop.getAdultList().get(i);

                if (anAdult.isAlive()) {

                    if (anAdult.getAge() >= dyingAge) {
                        anAdult.setDead();
                        /*
                         if (anAdult.getRiskAverse()) {
                         riskAversePopCount--;
                         } else {
                         riskNeutralPopCount--;
                         }
                         */
                    } else {
                        // anAdult.addMoney(socResource/(riskAversePopCount+riskNeutralPopCount));  //or just $2.5
                        anAdult.setMoney(anAdult.hasMoney()+moneyEarned);
                        anAdult.bet();  //here adult can have bet with the only $2.5 left
                        anAdult.feedSelf(surviveMoney);
                        anAdult.reproduction(); //in the same sec, can produce and feed
                        anAdult.addAge();
                    }
                }
                if (anAdult.getLifetimeChildProduced() > 0) {
                    for (int j = 0; j < anAdult.getChildList().size(); j++) {
                        Child aChild = anAdult.getChildList().get(j);

                        if (!anAdult.isAlive()) {
                            aChild.setDead();
                        } else if (aChild.getAge() == comingOfAge) {
                            aChild.setOfAge();
                            Adult newAdult = new Adult();
                            newAdult.setRiskAverse(anAdult.getRiskAverse());
                            /*
                             if (anAdult.getRiskAverse()) { //newAdult here
                             riskAversePopCount++;
                             } else {
                             riskNeutralPopCount++;
                             }
                             */
                            thePop.getAdultList().add(newAdult);
                            anAdult.addLifetimeChildGrown();
                        } else if (aChild.getAge() < comingOfAge) {
                            anAdult.feedChild();
                            aChild.addAge();
                        }
                    }
                }
                System.out.println("Adult " + i + " is " + anAdult.getAge() + " old. Is alive? " + anAdult.isAlive() + " Risk Averse?" + anAdult.getRiskAverse() + " , has $" + anAdult.hasMoney() + " He produced " + anAdult.getLifetimeChildProduced() + " children, " + anAdult.childListString());
                //later change to toString method in adult class
                anAdult.setMoney(anAdult.hasMoney()*0.9);
            }

            duration--;
            time++;            
            //  socResource = Math.round(socResource*0.9);
        }

    }

    static void populationTally(){
        for (Adult anAdult : thePop.getAdultList()) {
            if (anAdult.getRiskAverse() && anAdult.isAlive()) {
                riskAversePopCount++;
            } else if (!anAdult.getRiskAverse() && anAdult.isAlive()) {
                riskNeutralPopCount++;
            }
        }
    }
}
