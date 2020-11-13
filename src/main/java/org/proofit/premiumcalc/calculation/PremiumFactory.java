package org.proofit.premiumcalc.calculation;

import org.proofit.premiumcalc.model.RiskType;

import java.util.EnumMap;


public class PremiumFactory {
    static FirePremium configuredFirePremium = new FirePremium();
    static TheftPremium configuredTheftPremium = new TheftPremium();

    private static final EnumMap<RiskType, Premium> riskToPremiumMapping = getDefaultRiskTypeToPremiumMapping();

    public static Premium getPremium(RiskType riskType) {
        return riskToPremiumMapping.get(riskType);
    }

    protected static EnumMap<RiskType, Premium> getDefaultRiskTypeToPremiumMapping() {
        EnumMap<RiskType, Premium> map = new EnumMap<>(RiskType.class);
        map.put(RiskType.FIRE, configuredFirePremium);
        map.put(RiskType.THEFT, configuredTheftPremium);
        return map;
    }
}
