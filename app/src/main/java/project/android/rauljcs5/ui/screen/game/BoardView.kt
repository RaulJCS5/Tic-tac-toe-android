package project.android.rauljcs5.ui.screen.game

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import project.android.rauljcs5.ui.screen.game.model.BOARD_SIDE
import project.android.rauljcs5.ui.screen.game.model.GameBoard
import project.android.rauljcs5.ui.screen.game.model.Position
@Composable
fun BoardView(
    board: GameBoard,
    onTileSelected: (at: Position) -> Unit,
    enabled: Boolean,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        repeat(BOARD_SIDE) { row ->
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(weight = 1.0f, fill = true)
            ) {
                repeat(BOARD_SIDE) { column ->
                    val at = Position(row, column)
                    TileView(
                        move = board[at],
                        enabled = enabled,
                        modifier = Modifier.weight(weight = 1.0f, fill = true),
                        onSelected = { onTileSelected(at) },
                    )
                    if (column != BOARD_SIDE - 1) { VerticalSeparator() }
                }
            }
            if (row != BOARD_SIDE - 1) { HorizontalSeparator() }
        }
    }
}

@Composable
private fun HorizontalSeparator() {
    Spacer(modifier = Modifier
        .fillMaxWidth()
        .height(8.dp)
        .background(MaterialTheme.colors.secondary)
    )
}

@Composable
private fun VerticalSeparator() {
    Spacer(modifier = Modifier
        .fillMaxHeight()
        .width(8.dp)
        .background(MaterialTheme.colors.secondary)
    )
}