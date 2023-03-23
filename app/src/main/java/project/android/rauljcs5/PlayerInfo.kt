package project.android.rauljcs5

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

data class PlayerInfo(val username: String, val id: UUID = UUID.randomUUID()) {
    init { require(username.isNotBlank()) }
}

@Parcelize
data class LocalPlayerDto(
    val username: String
) : Parcelable

fun PlayerInfo.toLocalDto() = LocalPlayerDto(username)

fun PlayerInfo(localDto: LocalPlayerDto): PlayerInfo {
    return PlayerInfo(username = localDto.username)
}