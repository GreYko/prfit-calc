package org.proofit.premiumcalc.calculation

import org.junit.jupiter.api.Test
import org.proofit.premiumcalc.model.RiskType


class PremiumFactoryTest {

    @Test
    fun getPremiumCalculator() {
        assert(PremiumFactory.getPremium(RiskType.FIRE) is FirePremium)
        assert(PremiumFactory.getPremium(RiskType.THEFT) is TheftPremium)
    }
}
