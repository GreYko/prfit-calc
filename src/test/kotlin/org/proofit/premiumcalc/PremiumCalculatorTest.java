package org.proofit.premiumcalc;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.proofit.premiumcalc.model.*;

import java.math.BigDecimal;
import java.util.List;

class PremiumCalculatorTest {
    PremiumCalculator calculator = new PremiumCalculator();

    @Test
    void businessSampleCalculation1() {
        var policy = new Policy("testPolicy", PolicyStatus.REGISTERED,
                List.of(new PolicyObject("testPolicyObject",
                        List.of(new PolicySubObject("subObject1", new BigDecimal("100.00"), RiskType.FIRE),
                                new PolicySubObject("subObject2", new BigDecimal("8.00"), RiskType.THEFT)))));
        Assertions.assertEquals(new BigDecimal("2.28"), calculator.calculate(policy));
    }

    @Test
    void businessSampleCalculation2() {
        var policy = new Policy("testPolicy", PolicyStatus.REGISTERED,
                List.of(new PolicyObject("testPolicyObject",
                        List.of(new PolicySubObject("subObject1", new BigDecimal("500.00"), RiskType.FIRE),
                                new PolicySubObject("subObject2", new BigDecimal("102.51"), RiskType.THEFT)))));
        Assertions.assertEquals(new BigDecimal("17.13"), calculator.calculate(policy));
    }

    @Test
    void businessSampleCalculation2_complex() {
        var policy = new Policy("testPolicy", PolicyStatus.REGISTERED,
                List.of(
                        new PolicyObject("testPolicyObject 1",
                                List.of(new PolicySubObject("subObject2", new BigDecimal("100.00"), RiskType.FIRE),
                                        new PolicySubObject("subObject2", new BigDecimal("0.51"), RiskType.THEFT))
                        ),
                        new PolicyObject("testPolicyObject 2",
                                List.of(new PolicySubObject("subObject1", new BigDecimal("300.00"), RiskType.FIRE),
                                        new PolicySubObject("subObject2", new BigDecimal("100.00"), RiskType.FIRE),
                                        new PolicySubObject("subObject2", new BigDecimal("100.00"), RiskType.THEFT),
                                        new PolicySubObject("subObject2", new BigDecimal("2.00"), RiskType.THEFT))
                        )
                ));
        Assertions.assertEquals(new BigDecimal("17.13"), calculator.calculate(policy));
    }
}
