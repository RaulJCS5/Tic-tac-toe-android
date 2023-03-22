package project.android.rauljcs5

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LocalUserDto(
    val username: String,
    val email: String
) : Parcelable