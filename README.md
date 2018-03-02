The objective of this simulation is to test the evolutionary advantageous of stable income for raising offspring, even when the expected utility for being risk neutral would be greater on average.

Both risk neutral and risk averse population start off with 100 people, with longevity at 50 seconds.

At each second, each adult individual earns $2.5 to be saved, or to bet on a coin flip which has 1/2 chance of winning $6.

Since in this setup, the bet has positive profit on average, the risk neutral population would bet 100% of the time.

The risk averse population would bet 70% of the time.

The stock of food (in their account) has to depreciate each second (multiply by 0.9) since food expires.

Each adult needs to spend $2 to survive per second.

The person (by itself) will automatically produce a child, whenever his savings is above $15, which will be subtracted by $5. Each child costs an additional $1 per second afterward. Children inherit the same risk preferences as their parents.

When the child matures after 15 seconds, he will earn like an adult, dissociates from costing the parent money. We increment the respective adult population's by 1. 

[Adult1, childA, childB, childC]
becomes-->
[ [Adult1, childB, childC]
[AdultA] ]

If at any time, the saving is less than $2 + x*$1 then the family members will die starting from the youngest on the ArrayList. Element 0 is the parent, gets $2 first, then the oldest child at element 1 gets $1 and so on. Anyone who doesn’t get money/food dies. 

After a , sort individuals of Population (A + B) by:
-Life time # of children produced
-Life time # of children became adults
-Longevity

**Next Steps:

1) Plot the convergence speed as a function of the variables being manipulated. Manipulate all the variables and pick the most interesting ones to plot. Convergence speed is the time it takes for 75% (or 100%) of the population to be taken over by one type of preference (and note which type is 75%; which type is 25%). Run it 50 times or use a greater population for each level of variable and calculate the average to get a more accurate measure.

2) Instead of Binomial variable, try Poisson variable or Exponential variable. Observe how the convergence plot above is different for each.
3) Simulate environmental resource constraints by setting a shared pool of dollars or resources, which will replenish at a fix rate. When total resource is not enough to be distributed for each individual, a random subset of population gets the resource, until the environmental replenishes again. This way, neither population will grow unbounded.

