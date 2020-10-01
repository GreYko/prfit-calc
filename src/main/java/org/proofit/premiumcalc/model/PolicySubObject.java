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

    public String subObjectName() {
        return subObjectName;
    }

    public BigDecimal sumInsured() {
        return sumInsured;
    }

    public RiskType riskType() {
        return riskType;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (PolicySubObject) obj;
        return Objects.equals(this.subObjectName, that.subObjectName) &&
                Objects.equals(this.sumInsured, that.sumInsured) &&
                Objects.equals(this.riskType, that.riskType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subObjectName, sumInsured, riskType);
    }

    @Override
    public String toString() {
        return "PolicySubObject[" +
                "subObjectName=" + subObjectName + ", " +
                "sumInsured=" + sumInsured + ", " +
                "riskType=" + riskType + ']';
    }

}
