package org.proofit.premiumcalc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.proofit.premiumcalc.helper.PolicyBuilder
import org.proofit.premiumcalc.model.RiskType
import java.math.BigDecimal

class PremiumCalculatorTest {
    private val calculator = PremiumCalculator()

    @Test
    fun businessSampleCalculation1() {
        val policy = PolicyBuilder.createPolicy()
                .withObject {
                    it
                            .withSubObject("100.00", RiskType.FIRE)
                            .withSubObject("8.00", RiskType.THEFT)
                }.build()
        Assertions.assertEquals(BigDecimal("2.28"), calculator.calculate(policy))
    }

    @Test
    fun businessSampleCalculation2() {
        val policy = PolicyBuilder.createPolicy()
                .withObject {
                    it
                            .withSubObject("500.00", RiskType.FIRE)
                            .withSubObject("102.51", RiskType.THEFT)
                }.build()

        Assertions.assertEquals(BigDecimal("17.13"), calculator.calculate(policy))
    }

    @Test
    fun businessSampleCalculation2_complex() {
        val policy = PolicyBuilder.createPolicy()
                .withObject {
                    it
                            .withSubObject("100.00", RiskType.FIRE)
                            .withSubObject("0.51", RiskType.THEFT)
                }.withObject {
                    it
                            .withSubObject("300.00", RiskType.FIRE)
                            .withSubObject("100.00", RiskType.FIRE)
                            .withSubObject("100.00", RiskType.THEFT)
                            .withSubObject("2.00", RiskType.THEFT)
                }.build()
        Assertions.assertEquals(BigDecimal("17.13"), calculator.calculate(policy))
    }
}
