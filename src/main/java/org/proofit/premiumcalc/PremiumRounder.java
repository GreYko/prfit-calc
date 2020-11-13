package org.proofit.premiumcalc;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PremiumRounder {
    protected static BigDecimal roundToMoney(BigDecimal value) {
        return value.setScale(2, RoundingMode.HALF_UP);
    }

}
