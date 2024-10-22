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
)

fun getModalSheetTypeIndex(modalSheetType: ModalSheetType): Int {
    return listOfModalSheetInformation.indexOfFirst { it.modalSheetType == modalSheetType }
        .takeIf { it != -1 } ?: 0
}