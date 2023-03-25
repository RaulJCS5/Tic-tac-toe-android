package project.android.rauljcs5

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

data class Player(val username: String, val id: UUID = UUID.randomUUID()) {
    init { require(username.isNotBlank()) }
}

@Parcelize
data class LocalPlayerDto(
    val username: String
) : Parcelable

fun Player.toLocalDto() = LocalPlayerDto(username)

fun Player(localDto: LocalPlayerDto): Player {
    return Player(username = localDto.username)
}