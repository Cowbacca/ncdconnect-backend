package org.ncdconnect.ncdconnect.profile.service

import org.ncdconnect.ncdconnect.profile.domain.Profile
import org.ncdconnect.ncdconnect.profile.domain.ProfileRepository
import org.ncdconnect.ncdconnect.profile.domain.UpdateProfileInput
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class ProfileService(private val profileRepository: ProfileRepository) {
    fun getProfileById(userId: String): Profile? = profileRepository.findById(userId)

    fun updateProfile(updateProfileInput: UpdateProfileInput): Profile {
        with(updateProfileInput) {
            val existingProfile = profileRepository.findById(id) ?: Profile.createEmpty(
                id
            )
            val updatedProfile = existingProfile.update(update)
            return profileRepository.save(updatedProfile)
        }
    }
}
