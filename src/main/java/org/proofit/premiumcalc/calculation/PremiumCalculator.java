package org.proofit.premiumcalc.calculation;

import java.math.BigDecimal;

public interface PremiumCalculator {
    BigDecimal getCoefficient(BigDecimal sumInsured);

    default BigDecimal calculate(BigDecimal sumInsured) {
        return sumInsured.multiply(getCoefficient(sumInsured));
    }
}
