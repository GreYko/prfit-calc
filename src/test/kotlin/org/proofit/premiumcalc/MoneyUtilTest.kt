package org.proofit.premiumcalc

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

import java.math.BigDecimal


class MoneyUtilTest {

    @Test
    fun roundToMoney() {
        assertEquals(BigDecimal("-1.23"), BigDecimal("-1.234").roundToMoney())
        assertEquals(BigDecimal("-1.24"), BigDecimal("-1.235").roundToMoney())
        assertEquals(BigDecimal("-1.24"), BigDecimal("-1.236").roundToMoney())

        assertEquals(BigDecimal("1.23"), BigDecimal("1.234").roundToMoney())
        assertEquals(BigDecimal("1.24"), BigDecimal("1.235").roundToMoney())
        assertEquals(BigDecimal("1.24"), BigDecimal("1.236").roundToMoney())

        assertEquals(BigDecimal("2.10"), BigDecimal("2.101").roundToMoney())
        assertEquals(BigDecimal("2.10"), BigDecimal("2.1").roundToMoney())

        assertEquals(BigDecimal("25.12"), BigDecimal("25.1219999999").roundToMoney())
        assertEquals(BigDecimal("123465422534525.12"), BigDecimal("123465422534525.1209999").roundToMoney())
    }
}
