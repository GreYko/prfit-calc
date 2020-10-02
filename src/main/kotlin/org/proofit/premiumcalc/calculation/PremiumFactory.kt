package org.proofit.premiumcalc.calculation

import org.proofit.premiumcalc.exceptions.ApplicationException
import org.proofit.premiumcalc.model.RiskType

object PremiumFactory {
    // TODO: add configurability for calculators
    var configuredFirePremium = FirePremium()
    var configuredTheftPremium = TheftPremium()
    fun getPremium(riskType: RiskType?): Premium {
        return when (riskType) {
            RiskType.FIRE -> configuredFirePremium
            RiskType.THEFT -> configuredTheftPremium
            else -> throw ApplicationException("No calculator for Policy Sub Object defined.")
        }
    }
}
