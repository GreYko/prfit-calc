package org.proofit.premiumcalc;

import org.proofit.premiumcalc.calculation.PremiumFactory;
import org.proofit.premiumcalc.model.Policy;
import org.proofit.premiumcalc.model.PolicyObject;
import org.proofit.premiumcalc.model.PolicySubObject;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class PremiumCalculator {

    public BigDecimal calculate(Policy policy) {
        var insuredSumsByRiskType =
                policy.objects().stream().map(PolicyObject::subObjects).flatMap(List::stream)
                        .collect(Collectors.groupingBy(PolicySubObject::riskType,
                                Collectors.reducing(BigDecimal.ZERO, PolicySubObject::sumInsured, BigDecimal::add)));

        var grandTotal = insuredSumsByRiskType.entrySet().stream()
                .map(sumInsuredTotal -> PremiumFactory.getPremium(sumInsuredTotal.getKey()).calculate(sumInsuredTotal.getValue()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return MoneyUtil.roundToMoney(grandTotal);
    }

}
