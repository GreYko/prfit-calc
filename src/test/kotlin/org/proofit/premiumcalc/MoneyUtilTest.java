package org.proofit.premiumcalc;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class MoneyUtilTest {

    @Test
    void roundToMoney() {
        assertEquals(new BigDecimal("-1.23"), MoneyUtil.roundToMoney(new BigDecimal("-1.234")));
        assertEquals(new BigDecimal("-1.24"), MoneyUtil.roundToMoney(new BigDecimal("-1.235")));
        assertEquals(new BigDecimal("-1.24"), MoneyUtil.roundToMoney(new BigDecimal("-1.236")));

        assertEquals(new BigDecimal("1.23"), MoneyUtil.roundToMoney(new BigDecimal("1.234")));
        assertEquals(new BigDecimal("1.24"), MoneyUtil.roundToMoney(new BigDecimal("1.235")));
        assertEquals(new BigDecimal("1.24"), MoneyUtil.roundToMoney(new BigDecimal("1.236")));

        assertEquals(new BigDecimal("2.10"), MoneyUtil.roundToMoney(new BigDecimal("2.101")));
        assertEquals(new BigDecimal("2.10"), MoneyUtil.roundToMoney(new BigDecimal("2.1")));

        assertEquals(new BigDecimal("25.12"), MoneyUtil.roundToMoney(new BigDecimal("25.1219999999")));
        assertEquals(new BigDecimal("123465422534525.12"), MoneyUtil.roundToMoney(new BigDecimal("123465422534525.1209999")));
    }
}
