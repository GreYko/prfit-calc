package org.proofit.premiumcalc.calculation

import java.math.BigDecimal

class TheftPremium : Premium {
    private val DEFAULT_COEFFICIENT = BigDecimal("0.11")
    private val ALTERNATIVE_COEFFICIENT = BigDecimal("0.05")
    private val DEFAULT_RISK_LIMIT = BigDecimal("15.00")

    private fun isDefaultRisk(sumInsuredFire: BigDecimal): Boolean {
        return sumInsuredFire < DEFAULT_RISK_LIMIT
    }

    override fun getCoefficient(sumInsured: BigDecimal): BigDecimal {
        return if (isDefaultRisk(sumInsured)) DEFAULT_COEFFICIENT else ALTERNATIVE_COEFFICIENT
    }
}
