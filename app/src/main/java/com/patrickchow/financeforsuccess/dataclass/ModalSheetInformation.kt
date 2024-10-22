package com.patrickchow.financeforsuccess.dataclass

data class ModalSheetInformation(
    val title: String,
    val description: String,
    val modalSheetType: ModalSheetType,
)

val listOfModalSheetInformation = listOf(
    ModalSheetInformation(
        title = "Principle",
        description = "This is the total amount of money that you'll begin with",
        modalSheetType = ModalSheetType.Principal
    ),
    ModalSheetInformation(
        title = "Interest Rate",
        description = "This is the amount of interest that you'll expect to receive",
        modalSheetType = ModalSheetType.Interest
    ),
    ModalSheetInformation(
        title = "Time (years)",
        description = "This is the total amount of years that the money will compound",
        modalSheetType = ModalSheetType.Time
    ),
)

fun getModalSheetTypeIndex(modalSheetType: ModalSheetType): Int {
    return listOfModalSheetInformation.indexOfFirst { it.modalSheetType == modalSheetType }
        .takeIf { it != -1 } ?: 0
}