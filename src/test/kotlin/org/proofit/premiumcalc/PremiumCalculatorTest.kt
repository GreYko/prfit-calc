package org.proofit.premiumcalc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.proofit.premiumcalc.model.Policy
import org.proofit.premiumcalc.model.PolicyObject
import org.proofit.premiumcalc.model.PolicyStatus
import org.proofit.premiumcalc.model.PolicySubObject
import org.proofit.premiumcalc.model.RiskType
import java.math.BigDecimal

class PremiumCalculatorTest {
    private val calculator = PremiumCalculator()

    @Test
    fun businessSampleCalculation1() {
        val policy = Policy("testPolicy", PolicyStatus.REGISTERED,
                listOf(PolicyObject("testPolicyObject",
                        listOf(PolicySubObject("subObject1", BigDecimal("100.00"), RiskType.FIRE),
                                PolicySubObject("subObject2", BigDecimal("8.00"), RiskType.THEFT)))))
        Assertions.assertEquals(BigDecimal("2.28"), calculator.calculate(policy))
    }

    @Test
    fun businessSampleCalculation2() {
        val policy = Policy("testPolicy", PolicyStatus.REGISTERED,
                listOf(PolicyObject("testPolicyObject",
                        listOf(PolicySubObject("subObject1", BigDecimal("500.00"), RiskType.FIRE),
                                PolicySubObject("subObject2", BigDecimal("102.51"), RiskType.THEFT)))))
        Assertions.assertEquals(BigDecimal("17.13"), calculator.calculate(policy))
    }

    @Test
    fun businessSampleCalculation2_complex() {
        val policy = Policy("testPolicy", PolicyStatus.REGISTERED,
                listOf(
                        PolicyObject("testPolicyObject 1",
                                listOf(PolicySubObject("subObject2", BigDecimal("100.00"), RiskType.FIRE),
                                        PolicySubObject("subObject2", BigDecimal("0.51"), RiskType.THEFT))
                        ),
                        PolicyObject("testPolicyObject 2",
                                listOf(PolicySubObject("subObject1", BigDecimal("300.00"), RiskType.FIRE),
                                        PolicySubObject("subObject2", BigDecimal("100.00"), RiskType.FIRE),
                                        PolicySubObject("subObject2", BigDecimal("100.00"), RiskType.THEFT),
                                        PolicySubObject("subObject2", BigDecimal("2.00"), RiskType.THEFT))
                        )
                ))
        Assertions.assertEquals(BigDecimal("17.13"), calculator.calculate(policy))
    }
}
