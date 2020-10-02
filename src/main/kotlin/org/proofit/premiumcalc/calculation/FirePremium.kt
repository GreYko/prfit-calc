package org.proofit.premiumcalc.calculation

import java.math.BigDecimal

class FirePremium : Premium {
    private val DEFAULT_COEFFICIENT = BigDecimal("0.014")
    private val HIGH_RISK_COEFFICIENT = BigDecimal("0.024")
    private val RISK_LIMIT = BigDecimal("100.00")

    private fun isDefaultRisk(sumInsuredFire: BigDecimal): Boolean {
        return sumInsuredFire <= RISK_LIMIT
    }

    override fun getCoefficient(sumInsured: BigDecimal): BigDecimal {
        return if (isDefaultRisk(sumInsured)) DEFAULT_COEFFICIENT else HIGH_RISK_COEFFICIENT
    }
}
