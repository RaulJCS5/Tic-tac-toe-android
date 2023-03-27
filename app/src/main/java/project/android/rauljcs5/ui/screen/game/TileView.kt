package project.android.rauljcs5.ui.screen.game

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import project.android.rauljcs5.R
import project.android.rauljcs5.ui.screen.game.model.Marker

@Composable
fun TileView(
    move: Marker?,
    enabled: Boolean,
    onSelected: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier
        .background(MaterialTheme.colors.background)
        .fillMaxSize(1.0f)
        .padding(12.dp)
        .clickable(enabled = move == null && enabled) { onSelected() }
    ) {
        if (move != null) {
            val marker = when (move) {
                Marker.CIRCLE -> R.drawable.circle_red
                Marker.CROSS -> R.drawable.cross_red
            }
            Image(
                painter = painterResource(id = marker),
                contentDescription = "",
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}