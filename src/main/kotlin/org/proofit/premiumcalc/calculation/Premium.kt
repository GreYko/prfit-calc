package org.proofit.premiumcalc.calculation

import java.math.BigDecimal

interface Premium {
    fun getCoefficient(sumInsured: BigDecimal): BigDecimal
    fun calculate(sumInsured: BigDecimal): BigDecimal {
        return sumInsured.multiply(getCoefficient(sumInsured))
    }
}
