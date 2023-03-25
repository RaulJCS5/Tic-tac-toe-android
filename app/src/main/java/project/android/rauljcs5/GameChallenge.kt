package project.android.rauljcs5

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import project.android.rauljcs5.ui.screen.lobby.Challenge

@Parcelize
data class GameChallenge(
    val localId: String,
    val localUser: String,
    val opponentId: String,
    val opponentUser: String,
) : Parcelable

fun GameChallenge(localPlayer: Player, challenge: Challenge): GameChallenge {
    val opponent =
        if (localPlayer == challenge.challenged) challenge.challenger
        else challenge.challenged
    return GameChallenge(
        localId = localPlayer.id.toString(),
        localUser = localPlayer.username,
        opponentId = opponent.id.toString(),
        opponentUser = opponent.username,
    )
}