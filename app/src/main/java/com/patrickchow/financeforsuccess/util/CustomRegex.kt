package com.patrickchow.financeforsuccess.util

import java.util.regex.Pattern

class CustomRegex {

    companion object {
        // Regular expression to match up to two decimal places and only one decimal point
        val dollarRegex = Pattern.compile("^(\\d*\\.?\\d{0,2})?$")
    }
}