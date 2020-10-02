package org.proofit.premiumcalc.calculation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

import java.math.BigDecimal


class FirePremiumTest {
    private val firePremium = FirePremium()

    @Test
    fun getCoefficient() {
        val lowCoefficient = BigDecimal("0.014")
        val highCoefficient = BigDecimal("0.024")

        assertEquals(lowCoefficient, firePremium.getCoefficient(BigDecimal("50.00")))
        assertEquals(lowCoefficient, firePremium.getCoefficient(BigDecimal("100.00")))
        assertEquals(highCoefficient, firePremium.getCoefficient(BigDecimal("150.00")))
    }
}
