package org.proofit.premiumcalc.calculation.subobject;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.proofit.premiumcalc.calculation.FirePremium;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirePremiumTest {
    FirePremium firePremium = new FirePremium();

    private final static String lowCoefficient = "0.014";
    private final static String highCoefficient = "0.024";

    @ParameterizedTest(name = "getCoefficient_{index}: premium amount ''{0}'' should have ''{1}'' coefficient applied")
    @CsvSource({
            "50.00," + lowCoefficient,
            "100.00," + lowCoefficient,
            "150.00," + highCoefficient,
    })
    void getCoefficient(BigDecimal premiumAmt, BigDecimal expectedCoef) {
        assertEquals(expectedCoef, firePremium.getCoefficient(premiumAmt));
    }
}
