package org.proofit.premiumcalc.calculation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.math.BigDecimal


class FirePremiumTest {
    companion object {
        private val firePremium = FirePremium()

        private const val lowCoefficient = "0.014"
        private const val highCoefficient = "0.024"
    }

    @ParameterizedTest(name = "getCoefficient_{index}: premium amount ''{0}'' should have ''{1}'' coefficient applied")
    @CsvSource(
            "50.00,$lowCoefficient",
            "100.00,$lowCoefficient",
            "150.00,$highCoefficient",
    )
    fun getCoefficient(premiumAmt: BigDecimal, expectedCoef: BigDecimal) {
        assertEquals(expectedCoef, firePremium.getCoefficient(premiumAmt))
    }
}
