package org.proofit.premiumcalc.calculation;

import org.proofit.premiumcalc.exceptions.ApplicationException;
import org.proofit.premiumcalc.model.RiskType;


public class PremiumFactory {
    static FirePremium configuredFirePremium = new FirePremium();
    static TheftPremium configuredTheftPremium = new TheftPremium();

    public static Premium getPremium(RiskType riskType) {
        switch (riskType) {
            case FIRE:
                return configuredFirePremium;
            case THEFT:
                return configuredTheftPremium;
            default:
                throw new ApplicationException("No calculator for Policy Sub Object with RiskType '" + riskType + "' defined.");
        }
    }
}
