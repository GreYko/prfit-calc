package org.proofit.premiumcalc.calculation;

import java.math.BigDecimal;

public class FirePremium implements PremiumCalculator {
    private static final BigDecimal DEFAULT_COEFFICIENT = new BigDecimal("0.014");
    private static final BigDecimal HIGH_RISK_COEFFICIENT = new BigDecimal("0.024");
    private static final BigDecimal RISK_LIMIT = new BigDecimal("100.00");

    private static boolean isDefaultRisk(BigDecimal sumInsuredFire) {
        return RISK_LIMIT.compareTo(sumInsuredFire) > -1;
    }

    @Override
    public BigDecimal getCoefficient(BigDecimal sumInsured) {
        return isDefaultRisk(sumInsured) ? DEFAULT_COEFFICIENT : HIGH_RISK_COEFFICIENT;
    }
}
