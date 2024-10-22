package com.patrickchow.financeforsuccess.dataclass

data class ModalSheetInformation(
    val title: String,
    val description: String,
    val modalSheetType: ModalSheetType,
)

val listOfModalSheetInformation = listOf(
    ModalSheetInformation(
        title = "Principal",
        description = "This is the total amount of money that you'll begin with.",
        modalSheetType = ModalSheetType.Principal
    ),
    ModalSheetInformation(
        title = "Interest Rate",
        description = "This is the amount of interest that you'll expect to receive.",
        modalSheetType = ModalSheetType.Interest
    ),
    ModalSheetInformation(
        title = "Time (years)",
        description = "This is the total number of years that the money will grow.",
        modalSheetType = ModalSheetType.Time
    ),
    ModalSheetInformation(
        title = "Bill Amount",
        description = "This is the total amount you were billed before taxes.",
        modalSheetType = ModalSheetType.Bill
    ),
    ModalSheetInformation(
        title = "Tip Percent",
        description = "This is the percentage amount that you plan on tipping. The average amount is 15%.",
        modalSheetType = ModalSheetType.TipPercent
    ),
    ModalSheetInformation(
        title = "Number of Payments",
        description = "This refers to the total number of payment periods or installments in your financial calculation. For example, if you plan to make monthly payments for 2 years, the number of payments would be 24 (12 payments per year × 2 years).",
        modalSheetType = ModalSheetType.Nper
    ),
    ModalSheetInformation(
        title = "Payment Amount",
        description = "This is the fixed amount of money that you will pay or receive in each period of your financial calculation. It can refer to loan payments, annuity payments, or any regular contributions you make over time. For example, if you are paying off a loan, this would be the monthly payment amount you need to make to fully pay off the loan by the end of the term.",
        modalSheetType = ModalSheetType.Pmt
    ),
    ModalSheetInformation(
        title = "Future Value",
        description = "This represents the amount of money you will have at the end of a specified period.",
        modalSheetType = ModalSheetType.FV
    ),
)

fun getModalSheetTypeIndex(modalSheetType: ModalSheetType): Int {
    return listOfModalSheetInformation.indexOfFirst { it.modalSheetType == modalSheetType }
        .takeIf { it != -1 } ?: 0
}