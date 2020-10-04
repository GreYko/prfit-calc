package org.proofit.premiumcalc.calculation;

import org.junit.jupiter.api.Test;
import org.proofit.premiumcalc.model.RiskType;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PremiumFactoryTest {

    @Test
    void getPremiumCalculator() {
        assertEquals(FirePremium.class, PremiumFactory.getPremium(RiskType.FIRE).getClass());
        assertEquals(TheftPremium.class, PremiumFactory.getPremium(RiskType.THEFT).getClass());
    }
}
