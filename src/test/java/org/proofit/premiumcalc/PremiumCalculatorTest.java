package org.proofit.premiumcalc;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.proofit.premiumcalc.helper.PolicyBuilder;
import org.proofit.premiumcalc.model.RiskType;

import java.math.BigDecimal;

class PremiumCalculatorTest {
    PremiumCalculator calculator = new PremiumCalculator();

    @Test
    void emptyPolicyCalculation() {
        var policy = PolicyBuilder.createPolicy().build();
        Assertions.assertEquals(new BigDecimal("0.00"), calculator.calculate(policy));
    }

    @Test
    void businessSample1SimpleCalculation() {
        var policy = PolicyBuilder.createPolicy()
                .withObject(o -> o
                        .withSubObject("100.00", RiskType.FIRE)
                        .withSubObject("8.00", RiskType.THEFT)
                ).build();
        Assertions.assertEquals(new BigDecimal("2.28"), calculator.calculate(policy));
    }

    @Test
    void businessSample2SimpleCalculation() {
        var policy = PolicyBuilder.createPolicy()
                .withObject(o -> o
                        .withSubObject("500.00", RiskType.FIRE)
                        .withSubObject("102.51", RiskType.THEFT)
                ).build();
        Assertions.assertEquals(new BigDecimal("17.13"), calculator.calculate(policy));
    }

    @Test
    void businessSample2ComplexCalculation() {
        var policy = PolicyBuilder.createPolicy()
                .withObject(o -> o
                        .withSubObject("100.00", RiskType.FIRE)
                        .withSubObject("0.51", RiskType.THEFT)
                ).withObject(o -> o
                        .withSubObject("300.00", RiskType.FIRE)
                        .withSubObject("100.00", RiskType.FIRE)
                        .withSubObject("100.00", RiskType.THEFT)
                        .withSubObject("2.00", RiskType.THEFT)
                ).build();
        Assertions.assertEquals(new BigDecimal("17.13"), calculator.calculate(policy));
    }
}
