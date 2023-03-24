package project.android.rauljcs5.ui.screen.game.model

const val BOARD_SIDE = 3

data class Position(
    val row: Int,
    val column: Int
    ) {
    init {
        require(isValidRow(row) && isValidColumn(column))
    }
}

fun isValidRow(value: Int) = value in 0 until BOARD_SIDE

fun isValidColumn(value: Int) = value in 0 until BOARD_SIDE

