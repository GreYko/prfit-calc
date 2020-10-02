package org.proofit.premiumcalc.calculation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal


class TheftPremiumTest {
    private val theftPremium = TheftPremium()

    @Test
    fun getCoefficient()
    {
        val lowCoefficient = BigDecimal("0.05")
        val highCoefficient = BigDecimal("0.11")

        assertEquals(highCoefficient, theftPremium.getCoefficient(BigDecimal("5.00")))
        assertEquals(lowCoefficient, theftPremium.getCoefficient(BigDecimal("15.00")))
        assertEquals(lowCoefficient, theftPremium.getCoefficient(BigDecimal("20.00")))
    }
}
