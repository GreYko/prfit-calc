package org.proofit.premiumcalc.model;

import java.math.BigDecimal;
import java.util.Objects;

public final class PolicySubObject {
    private final String subObjectName;
    private final BigDecimal sumInsured;
    private final RiskType riskType;

    public PolicySubObject(String subObjectName, BigDecimal sumInsured, RiskType riskType) {
        this.subObjectName = subObjectName;
        this.sumInsured = sumInsured;
        this.riskType = riskType;
    }

    public String getSubObjectName() {
        return subObjectName;
    }

    public BigDecimal getSumInsured() {
        return sumInsured;
    }

    public RiskType getRiskType() {
        return riskType;
    }
}
