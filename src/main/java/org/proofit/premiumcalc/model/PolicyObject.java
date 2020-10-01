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

    public String objectName() {
        return objectName;
    }

    public List<PolicySubObject> subObjects() {
        return subObjects;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (PolicyObject) obj;
        return Objects.equals(this.objectName, that.objectName) &&
                Objects.equals(this.subObjects, that.subObjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objectName, subObjects);
    }

    @Override
    public String toString() {
        return "PolicyObject[" +
                "objectName=" + objectName + ", " +
                "subObjects=" + subObjects + ']';
    }

}
