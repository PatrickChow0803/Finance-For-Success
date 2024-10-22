package com.patrickchow.financeforsuccess.util

class MathFormulas {
    companion object {
        // Calculate compound interest: A = P (1 + r/n)^(nt)
        fun calculateCompoundInterest(p: Double, r: Double, numberOfCompoundPerYear: Int, t: Double): Double {
            return p * Math.pow((1 + r / numberOfCompoundPerYear), (numberOfCompoundPerYear * t))
        }

        // Calculate simple interest: SI = (P * R * T) / 100
        fun calculateSimpleInterest(p: Double, r: Double, t: Double): Double {
            return (p * r * t) / 100
        }

        fun calculateTip(bill: Double, tipPercent: Double): Double {
            return bill * (tipPercent / 100)
        }

        fun calculatePV(rate: Double, nper: Int, pmt: Double, fv: Double = 0.0, type: Int = 0): Double {
            val pvFactor = if (type == 0) {
                (1 - Math.pow(1 + rate, (-nper).toDouble())) / rate
            } else {
                (1 - Math.pow(1 + rate, (-nper).toDouble())) / rate * (1 + rate)
            }
            return -pmt * pvFactor + fv / Math.pow(1 + rate, nper.toDouble())
        }

    }
}