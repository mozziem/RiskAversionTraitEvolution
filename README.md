**Purpose of modeling: **

**To see whether it is evolutionary advantageous to have stable income
for reproduction, even though the expected utility for being risk
neutral would have been greater.**

At each second, each adult individual earns $2.5 for savings or to 
bet on a flipping coin, to win ($6).

The stock of food (in their account) has to depreciate each second
(multiply by 0.9) since food expires.

When the bet has positive profit on average, as in this setup, risk neutral 
population would bet 100% of time.

Risk averse population would bet with 0.7 probability.

Both risk neutral and risk averse population start off with (100) people,
with longevity at 50 seconds.

Each second each adult needs to spend $2 to survive.

If the current saving is above $15 then the person automatically
produces a child with savings simultaneously subtracted by $5. Child
costs an additional $1 each second afterward. Asexual reproduction.
Children have the save risk preference as their parent.

After 15 seconds, the child matures (respective adult’s population +1),
earns like adult and dissociates from costing the parent money (leaves
old array, forms a new array).

If at any time, the saving is less than $2 + x\*$1 then the family
members will die starting from the youngest on the ArrayList. Element 0
is the parent, gets $2 first, then the oldest child at element 1 gets $1
and so on. Anyone who doesn’t get money/food dies.

In each simulation run, sort individuals of Population (A + B):

Life time \# of children produced

Life time \# of children became adults

Longevity

Next Steps:

Plot the convergence speed as a function of the variables being
manipulated. Manipulate all the variables and pick the most interesting
ones to plot. Convergence speed is the time it takes for 75% (or 100%)
of the population to be taken over by one type of preference (and note
which type is 75%; which type is 25%). Run it 50 times or use a greater
population for each level of variable and **calculate the average** to
get a more accurate measure.
