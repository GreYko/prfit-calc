package org.proofit.premiumcalc.calculation;

import java.math.BigDecimal;

public class FirePremium implements Premium {
    private static final BigDecimal DEFAULT_COEFFICIENT = new BigDecimal("0.014");
    private static final BigDecimal ALTERNATIVE_COEFFICIENT = new BigDecimal("0.024");
    private static final BigDecimal RISK_LIMIT = new BigDecimal("100.00");

    @Override
    public BigDecimal getCoefficient(BigDecimal sumInsured) {
        return shouldDefaultRiskBeUsedFor(sumInsured) ? DEFAULT_COEFFICIENT : ALTERNATIVE_COEFFICIENT;
    }

    private static boolean shouldDefaultRiskBeUsedFor(BigDecimal sumInsuredFire) {
        return RISK_LIMIT.compareTo(sumInsuredFire) > -1;
    }
}
