package org.proofit.premiumcalc;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyUtilTest {

    @ParameterizedTest(name = "roundToMoney_{index}: ''{0}'' should be rounded to ''{1}''")
    @CsvSource({
            "-1.234,-1.23",
            "-1.235,-1.24",
            "-1.236,-1.24",
            "1.234,1.23",
            "1.235,1.24",
            "1.236,1.24",
            "2.101,2.10",
            "2.1,2.10",
            "25.1219999999,25.12",
            "123465422534525.1209999,123465422534525.12"
    })
    void roundToMoney(BigDecimal input, BigDecimal expectedOutput) {
        assertEquals(expectedOutput, MoneyUtil.roundToMoney(input));
    }
}
