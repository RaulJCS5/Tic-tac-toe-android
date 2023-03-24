package project.android.rauljcs5

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import project.android.rauljcs5.ui.screen.lobby.Challenge
import java.util.*

@Parcelize
data class GameChallengeInfo(
    val localId: String,
    val localUser: String,
    val opponentId: String,
    val opponentUser: String,
) : Parcelable

fun GameChallengeInfo(localPlayer: PlayerInfo, challenge: Challenge): GameChallengeInfo {
    val opponent =
        if (localPlayer == challenge.challenged) challenge.challenger
        else challenge.challenged
    return GameChallengeInfo(
        localId = localPlayer.id.toString(),
        localUser = localPlayer.username,
        opponentId = opponent.id.toString(),
        opponentUser = opponent.username,
    )
}