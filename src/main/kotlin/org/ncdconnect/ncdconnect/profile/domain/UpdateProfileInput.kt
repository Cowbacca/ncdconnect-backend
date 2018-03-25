package org.ncdconnect.ncdconnect.profile.domain

data class UpdateProfileInput(
    val userId: String,
    val update: ProfileUpdate
) {

    data class ProfileUpdate(
        val name: String
    )
}
