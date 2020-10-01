package org.proofit.premiumcalc.model;

import java.math.BigDecimal;

public record PolicySubObject(String subObjectName, BigDecimal sumInsured, RiskType riskType) {
}
