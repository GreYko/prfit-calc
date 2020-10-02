package org.proofit.premiumcalc

import java.math.BigDecimal
import java.math.RoundingMode

internal fun BigDecimal.roundToMoney(): BigDecimal = this.setScale(2, RoundingMode.HALF_UP)
