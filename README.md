**Purpose of modeling: **

**To see whether it is evolutionary advantageous to have stable income
for reproduction, even though the expected utility for being risk
neutral would have been greater.**

At each second, each adult individual earns $2.5 to bet on a flipping
coin, to win ($6) or else save it into their account.

The stock of food (in their account) has to depreciate each second
(multiply by 0.9) since food expires.

Individuals were classified as risk neutral or at a certain level of
risk averse.

Under optimal circumstance, for risk neutral people they would bet 100%
of time, or 1.0 probability.

For people who are somewhat risk averse, they would bet w/ say 0.7
probability.

Both risk neutral and risk averse start off with (100) people population
and dies off automatically after 50 seconds.

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
