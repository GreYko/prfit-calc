package org.proofit.premiumcalc.model;

import java.util.List;
import java.util.Objects;

public final class Policy {
    private final String policyNumber;
    private final PolicyStatus status;
    private final List<PolicyObject> objects;

    public Policy(String policyNumber, PolicyStatus status, List<PolicyObject> objects) {
        this.policyNumber = policyNumber;
        this.status = status;
        this.objects = objects;
    }

    public List<PolicyObject> getObjects() {
        return objects;
    }
}
