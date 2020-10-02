package org.proofit.premiumcalc

import org.proofit.premiumcalc.calculation.PremiumFactory
import org.proofit.premiumcalc.model.Policy
import java.math.BigDecimal

class PremiumCalculator {
    fun calculate(policy: Policy): BigDecimal {
        val insuredSumsByRiskType = policy.objects
                .flatMap { it.subObjects }
                .map { it.riskType to it.sumInsured }
                .groupBy { it.first }
                .mapValues { entry -> entry.value.sumOf { it.second } }

        val grandTotal = insuredSumsByRiskType
                .map { sumInsuredTotal -> PremiumFactory.getPremium(sumInsuredTotal.key).calculate(sumInsuredTotal.value) }
                .reduce(BigDecimal::add)

        return grandTotal.roundToMoney()
    }
}
