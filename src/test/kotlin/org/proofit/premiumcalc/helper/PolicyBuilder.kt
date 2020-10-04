package org.proofit.premiumcalc.helper

import org.proofit.premiumcalc.model.Policy
import org.proofit.premiumcalc.model.PolicyObject
import org.proofit.premiumcalc.model.PolicyStatus
import org.proofit.premiumcalc.model.PolicySubObject
import org.proofit.premiumcalc.model.RiskType
import java.math.BigDecimal
import java.util.function.Function


class PolicyBuilder private constructor() {
    private val policyObjects: MutableList<PolicyObject> = mutableListOf()
    private var policyObjectCounter = 0

    fun withObject(f: Function<PolicyObjectBuilder, PolicyObjectBuilder>): PolicyBuilder {
        policyObjects.add(f.apply(PolicyObjectBuilder()).build(++policyObjectCounter))
        return this
    }

    fun build(): Policy {
        return Policy("Policy", PolicyStatus.REGISTERED, policyObjects)
    }

    class PolicyObjectBuilder {
        private val subObjects: MutableList<PolicySubObject> = mutableListOf()
        private var subObjectCounter = 0
        fun withSubObject(sumInsured: String, riskType: RiskType): PolicyObjectBuilder {
            return withSubObject(BigDecimal(sumInsured), riskType)
        }

        fun withSubObject(sumInsured: BigDecimal, riskType: RiskType): PolicyObjectBuilder {
            subObjects.add(PolicySubObject("SubObject_" + ++subObjectCounter, sumInsured, riskType))
            return this
        }

        internal fun build(policyObjectNumber: Int): PolicyObject {
            return PolicyObject("PolicyObject_$policyObjectNumber", subObjects)
        }
    }

    companion object {
        fun createPolicy(): PolicyBuilder {
            return PolicyBuilder()
        }
    }
}
