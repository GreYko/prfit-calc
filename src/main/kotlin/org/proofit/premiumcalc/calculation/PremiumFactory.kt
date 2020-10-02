package org.proofit.premiumcalc.calculation

import org.proofit.premiumcalc.model.RiskType

object PremiumFactory {
    // TODO: add configurability for calculators
    var configuredFirePremium = FirePremium()
    var configuredTheftPremium = TheftPremium()
    fun getPremium(riskType: RiskType): Premium {
        return when (riskType) {
            RiskType.FIRE -> configuredFirePremium
            RiskType.THEFT -> configuredTheftPremium
        }
    }
}
