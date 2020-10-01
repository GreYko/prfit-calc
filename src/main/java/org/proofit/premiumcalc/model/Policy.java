package org.proofit.premiumcalc.model;

import java.util.List;

public record Policy(String policyNumber, PolicyStatus status, List<PolicyObject> objects) {
}
