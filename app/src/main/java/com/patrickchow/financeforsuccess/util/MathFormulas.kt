package com.patrickchow.financeforsuccess.util

class MathFormulas {
    companion object {

        // Calculate simple interest: SI = (P * R * T) / 100
        fun calculateSimpleInterest(p: Double, r: Double, t: Double): Double {
            return (p * r * t) / 100
        }

        fun calculateTip(bill: Double, tipPercent: Double): Double {
            return bill * (tipPercent / 100)
        }

        fun calculateFV(rate: Double, nper: Int, pmt: Double, pv: Double = 0.0, type: Int = 0): Double {
            // Contributions at the end of the period
            return if (type == 0) {
                pv * Math.pow(1 + rate, nper.toDouble()) +
                        pmt * ((Math.pow(1 + rate, nper.toDouble()) - 1) / rate)
            // Contributions at the beginning of the period
            } else {
                pv * Math.pow(1 + rate, nper.toDouble()) +
                        pmt * ((Math.pow(1 + rate, nper.toDouble()) - 1) / rate) * (1 + rate)
            }
        }

        fun calculatePV(rate: Double, nper: Int, pmt: Double, fv: Double, type: Int = 0): Double {
            val fvFactor = Math.pow(1 + rate, nper.toDouble())
            // Contributions at the end of the period
            return if (type == 0) {
                (fv - pmt * ((fvFactor - 1) / rate)) / fvFactor
            // Contributions at the beginning of the period
            } else {
                (fv - pmt * ((fvFactor - 1) / rate) * (1 + rate)) / fvFactor
            }
        }
    }
}