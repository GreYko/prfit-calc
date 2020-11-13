package org.proofit.premiumcalc.calculation;

import java.math.BigDecimal;

public class TheftPremium implements Premium {
    private static final BigDecimal DEFAULT_COEFFICIENT = new BigDecimal("0.11");
    private static final BigDecimal ALTERNATIVE_COEFFICIENT = new BigDecimal("0.05");
    private static final BigDecimal DEFAULT_RISK_LIMIT = new BigDecimal("15.00");

    @Override
    public BigDecimal getCoefficient(BigDecimal sumInsured) {
        return shouldDefaultRiskBeUsedFor(sumInsured) ? DEFAULT_COEFFICIENT : ALTERNATIVE_COEFFICIENT;
    }

    private static boolean shouldDefaultRiskBeUsedFor(BigDecimal sumInsuredFire) {
        return DEFAULT_RISK_LIMIT.compareTo(sumInsuredFire) > 0;
    }
}
