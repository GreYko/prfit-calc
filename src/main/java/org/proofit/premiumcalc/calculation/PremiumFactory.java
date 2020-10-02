package org.proofit.premiumcalc.calculation;

import org.proofit.premiumcalc.model.RiskType;


public class PremiumFactory {
    // TODO: add configurability for calculators
    static FirePremium configuredFirePremium = new FirePremium();
    static TheftPremium configuredTheftPremium = new TheftPremium();

    public static Premium getPremium(RiskType riskType) {
        return switch (riskType) {
            case FIRE -> configuredFirePremium;
            case THEFT -> configuredTheftPremium;
        };
    }
}
