package org.proofit.premiumcalc.model;

import java.util.List;
import java.util.Objects;

public final class PolicyObject {
    private final String objectName;
    private final List<PolicySubObject> subObjects;

    public PolicyObject(String objectName, List<PolicySubObject> subObjects) {
        this.objectName = objectName;
        this.subObjects = subObjects;
    }

    public String getObjectName() {
        return objectName;
    }

    public List<PolicySubObject> getSubObjects() {
        return subObjects;
    }
}
