package org.proofit.premiumcalc.model

import java.math.BigDecimal

data class Policy(
        val policyNumber: String,
        val status: PolicyStatus,
        val objects: List<PolicyObject>
)

data class PolicyObject(
        val objectName: String,
        val subObjects: List<PolicySubObject>
)

data class PolicySubObject(
        val subObjectName: String,
        val sumInsured: BigDecimal,
        val riskType: RiskType
)


enum class PolicyStatus {
    REGISTERED, APPROVED
}

enum class RiskType {
    FIRE, THEFT
}
