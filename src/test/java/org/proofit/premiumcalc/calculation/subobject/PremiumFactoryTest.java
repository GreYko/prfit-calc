package org.proofit.premiumcalc.calculation.subobject;

import org.junit.jupiter.api.Test;
import org.proofit.premiumcalc.calculation.FirePremium;
import org.proofit.premiumcalc.calculation.PremiumFactory;
import org.proofit.premiumcalc.calculation.TheftPremium;
import org.proofit.premiumcalc.model.RiskType;


import static org.junit.jupiter.api.Assertions.*;

class PremiumFactoryTest {

    @Test
    void getPremiumCalculator() {
        assertEquals(FirePremium.class, PremiumFactory.getPremiumCalculator(RiskType.FIRE).getClass());
        assertEquals(TheftPremium.class, PremiumFactory.getPremiumCalculator(RiskType.THEFT).getClass());
    }
}
