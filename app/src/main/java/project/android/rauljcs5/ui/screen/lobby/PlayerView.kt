package project.android.rauljcs5.ui.screen.lobby

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import project.android.rauljcs5.Player

@Composable
fun PlayerView(
    player: Player,
    onPlayerSelected: (Player) -> Unit
){
    Card(
        modifier = Modifier
            .clickable { onPlayerSelected(player) }
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = player.username,
                style = MaterialTheme.typography.subtitle1,
            )
        }
    }
}