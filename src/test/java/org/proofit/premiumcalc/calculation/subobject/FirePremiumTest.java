package org.proofit.premiumcalc.calculation.subobject;

import org.junit.jupiter.api.Test;
import org.proofit.premiumcalc.calculation.FirePremium;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class FirePremiumTest {
    FirePremium firePremium = new FirePremium();

    @Test
    void getCoefficient() {
        var lowCoefficient = new BigDecimal("0.014");
        var highCoefficient = new BigDecimal("0.024");

        assertEquals(lowCoefficient, firePremium.getCoefficient(new BigDecimal("50.00")));
        assertEquals(lowCoefficient, firePremium.getCoefficient(new BigDecimal("100.00")));
        assertEquals(highCoefficient, firePremium.getCoefficient(new BigDecimal("150.00")));
    }
}
