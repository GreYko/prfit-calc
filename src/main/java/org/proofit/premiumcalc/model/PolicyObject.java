package org.proofit.premiumcalc.model;

import java.util.List;

public record PolicyObject(String objectName, List<PolicySubObject> subObjects) {
}
