package project.android.rauljcs5

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * The domain entity for representing users
 */
data class User(val username: String) {
    init { require(username.isNotBlank()) }
}

@Parcelize
data class LocalPlDto(
    val username: String,
) : Parcelable

/**
 * Converts this user to a local DTO, that can be placed in Bundles and
 * passed around between activities.
 */
fun User.toLocalDto() = LocalPlDto(username)

/**
 * Creates a [User] instance from the given DTO
 */
fun User(localDto: LocalPlDto): User {
    return User(username = localDto.username)
}
