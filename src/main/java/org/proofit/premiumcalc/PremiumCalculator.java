package org.proofit.premiumcalc;

import org.proofit.premiumcalc.calculation.PremiumFactory;
import org.proofit.premiumcalc.model.Policy;
import org.proofit.premiumcalc.model.PolicyObject;
import org.proofit.premiumcalc.model.PolicySubObject;
import org.proofit.premiumcalc.model.RiskType;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PremiumCalculator {

    public BigDecimal calculate(Policy policy) {
        var insuredSumsByRiskType = getInsuredSumsByRiskType(policy);
        var grandTotal = calculateGrandTotal(insuredSumsByRiskType);
        return PremiumRounder.roundToMoney(grandTotal);
    }

    private Map<RiskType, BigDecimal> getInsuredSumsByRiskType(Policy policy) {
        return policy
                .getObjects()
                .stream()
                .map(PolicyObject::getSubObjects)
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(PolicySubObject::getRiskType,
                        Collectors.reducing(BigDecimal.ZERO, PolicySubObject::getSumInsured, BigDecimal::add)));
    }

    private BigDecimal calculateGrandTotal(Map<RiskType, BigDecimal> insuredSumsByRiskType) {
        return insuredSumsByRiskType
                .entrySet()
                .stream()
                .map(sumInsuredTotal -> PremiumFactory.getPremium(sumInsuredTotal.getKey()).calculate(sumInsuredTotal.getValue()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
