package org.proofit.premiumcalc.calculation.subobject;

import org.junit.jupiter.api.Test;
import org.proofit.premiumcalc.calculation.TheftPremium;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TheftPremiumTest {
    TheftPremium theftPremium = new TheftPremium();

    @Test
    void getCoefficient() {
        var lowCoefficient = new BigDecimal("0.05");
        var highCoefficient = new BigDecimal("0.11");

        assertEquals(highCoefficient, theftPremium.getCoefficient(new BigDecimal("5.00")));
        assertEquals(lowCoefficient, theftPremium.getCoefficient(new BigDecimal("15.00")));
        assertEquals(lowCoefficient, theftPremium.getCoefficient(new BigDecimal("20.00")));
    }
}
