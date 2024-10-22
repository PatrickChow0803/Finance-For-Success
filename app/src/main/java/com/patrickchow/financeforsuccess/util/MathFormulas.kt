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

        // Present value formula: PV = FV / (1 + r)^t
        fun calculatePresentValue(fv: Double, rate: Double, time: Double): Double {
            return fv / Math.pow(1 + rate, time)
        }
    }
}