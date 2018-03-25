package org.ncdconnect.ncdconnect.profile.domain

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Profile(
    @Id
    private val userId: String,
    private val name: String
) {
    companion object {
        fun createEmpty(userId: String): Profile =
            Profile(userId = userId, name = "")
    }

    fun update(update: UpdateProfileInput.ProfileUpdate): Profile {
        return copy(
            name = update.name
        )
    }
}
