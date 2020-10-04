package org.proofit.premiumcalc.helper;

import org.proofit.premiumcalc.model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class PolicyBuilder {

    public static PolicyBuilder createPolicy() {
        return new PolicyBuilder();
    }

    private List<PolicyObject> policyObjects = new ArrayList<>();
    private int policyObjectCounter = 0;

    private PolicyBuilder() {
    }

    public PolicyBuilder withObject(Function<PolicyObjectBuilder, PolicyObjectBuilder> f) {
        policyObjects.add(f.apply(new PolicyObjectBuilder()).build(++policyObjectCounter));
        return this;
    }

    public Policy build() {
        return new Policy("Policy", PolicyStatus.REGISTERED, policyObjects);
    }

    public static class PolicyObjectBuilder {

        private List<PolicySubObject> subObjects = new ArrayList<>();

        private int subObjectCounter = 0;

        public PolicyObjectBuilder withSubObject(String sumInsured, RiskType riskType) {
            return withSubObject(new BigDecimal(sumInsured), riskType);
        }

        public PolicyObjectBuilder withSubObject(BigDecimal sumInsured, RiskType riskType) {
            subObjects.add(new PolicySubObject("SubObject_" + ++subObjectCounter, sumInsured, riskType));
            return this;
        }

        private PolicyObject build(int policyObjectNumber) {
            return new PolicyObject("PolicyObject_" + policyObjectNumber, subObjects);
        }
    }
}
