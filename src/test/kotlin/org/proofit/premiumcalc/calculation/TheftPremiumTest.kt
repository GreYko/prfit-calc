package org.proofit.premiumcalc.calculation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.math.BigDecimal


class TheftPremiumTest {
    companion object {
        private val theftPremium = TheftPremium()

        private const val lowCoefficient = "0.05"
        private const val highCoefficient = "0.11"
    }

    @ParameterizedTest(name = "getCoefficient_{index}: premium amount ''{0}'' should have ''{1}'' coefficient applied")
    @CsvSource(
            "5.00,$highCoefficient",
            "15.00,$lowCoefficient",
            "20.00,$lowCoefficient",
    )
    fun getCoefficient(premiumAmt: BigDecimal, expectedCoef: BigDecimal) {
        assertEquals(expectedCoef, theftPremium.getCoefficient(premiumAmt))
    }
}
