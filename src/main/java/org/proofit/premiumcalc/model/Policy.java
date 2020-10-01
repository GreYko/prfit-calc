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

    public String policyNumber() {
        return policyNumber;
    }

    public PolicyStatus status() {
        return status;
    }

    public List<PolicyObject> objects() {
        return objects;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Policy) obj;
        return Objects.equals(this.policyNumber, that.policyNumber) &&
                Objects.equals(this.status, that.status) &&
                Objects.equals(this.objects, that.objects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber, status, objects);
    }

    @Override
    public String toString() {
        return "Policy[" +
                "policyNumber=" + policyNumber + ", " +
                "status=" + status + ", " +
                "objects=" + objects + ']';
    }

}
