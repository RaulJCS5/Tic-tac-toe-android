package project.android.rauljcs5

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * The domain entity for representing users
 */
data class User(val username: String, val password: String) {
    init { require(username.isNotBlank() && password.isNotBlank()) }
}

@Parcelize
data class LocalUserDto(
    val username: String,
    val password: String
) : Parcelable

/**
 * Converts this user to a local DTO, that can be placed in Bundles and
 * passed around between activities.
 */
fun User.toLocalDto() = LocalUserDto(username, password)

/**
 * Creates a [User] instance from the given DTO
 */
fun User(localDto: LocalUserDto): User {
    return User(username = localDto.username, password = localDto.password)
}
