package project.android.rauljcs5.ui.screen.game.model

data class GameBoard(
    val turn: Marker = Marker.firstToMove,
    val board: List<List<Marker?>> =
        List(
            size = BOARD_SIDE,
            init = { List(size = BOARD_SIDE, init = { null }) }
        )
) {
    operator fun get(position: Position): Marker? = getMove(position)
    fun getMove(position: Position): Marker? = board[position.row][position.column]
    fun makeMove(position: Position): GameBoard {
        check(this[position] == null)
        val transformTiles = board.mapIndexed { row, elem ->
            if (row == position.row) {
                List(board[row].size) { col ->
                    if (col == position.column) {
                        turn
                    } else {
                        board[row][col]
                    }
                }
            } else {
                elem
            }
        }
        return GameBoard(
            turn = turn.other,
            board = transformTiles
        )
    }

    fun toMovesList(): List<Marker?> = board.flatten()
    fun isTied(): Boolean {
        return toMovesList().all { it != null } && !hasWon(Marker.CIRCLE) && !hasWon(Marker.CROSS)
    }

    fun hasWon(marker: Marker): Boolean =
        board.any { row ->
            row.all {
                it == marker
            } ||
                    (0 until BOARD_SIDE).any { column ->
                        (0 until BOARD_SIDE).all { row -> board[row][column] == marker }
                    } ||
                    //Diagonal
                    board[0][0] == marker && board[1][1] == marker && board[2][2] == marker ||
                    board[0][2] == marker && board[1][1] == marker && board[2][0] == marker
        }
}