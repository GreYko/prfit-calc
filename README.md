# ProofIt Premium Calculator Homework

## Prerequisites

* Java 11

## Implementation 

### Notes

Initially decided to start with most modern Java version available (15) to play around with records, which theoretically should improve codebase.
After reaching assessment goal had to rid of preview functionality as it might lead to unwanted behaviour in real production later on.
Sorry for being tiny bit of religious there, but Kotlin version branch is also attached for evaluation. Most likely transition wasn't driven in a best, most safe/compatible way, but hey we're rarely doing such things without preparations, and we definitely can do that job better if needed. 

### Dependency Injection wasn't used

For now, I see not too many reasons for DI usage as it's just another dependency to worry about later on.
So decided to make project with almost no dependencies at first iteration.

### Adding new Risk Type

1. Add new RiskType to `org.proofit.premiumcalc.model.RiskType`
1. Go to `org.proofit.premiumcalc.calculation`
    2. If needed, create new implementation of `Premium`
    2. Configure `PremiumFactory.getPremiumCalculator`
    
#### Risks

If `org.proofit.premiumcalc.calculation.PremiumFactory` wasn't configured - Application build will fail.

### What can be improved

* Configuration of coefficients and limits for `FirePremium` and `TheftPremium`
* DI configuration might replace `PremiumFactory`
* Experiment with grouping reducer and flat maps due to existing implementation isn't most readable one (`PremiumCalculator`)
* Test package might benefit from creating Policy builder in order to increase readability

## Assumptions

##### Policy status is irrelevant for premium calculation

##### All provided amounts will have same currency
For now no currency handling was added.
