package org.proofit.premiumcalc.calculation.subobject;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.proofit.premiumcalc.calculation.TheftPremium;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TheftPremiumTest {
    TheftPremium theftPremium = new TheftPremium();

    private final static String lowCoefficient = "0.05";
    private final static String highCoefficient = "0.11";

    @ParameterizedTest(name = "getCoefficient_{index}: premium amount ''{0}'' should have ''{1}'' coefficient applied")
    @CsvSource({
            "5.00," + highCoefficient,
            "15.00," + lowCoefficient,
            "20.00," + lowCoefficient,
    })
    void getCoefficient(BigDecimal premiumAmt, BigDecimal expectedCoef) {
        assertEquals(expectedCoef, theftPremium.getCoefficient(premiumAmt));
    }
}
