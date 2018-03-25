package org.ncdconnect.ncdconnect.profile.service

import org.ncdconnect.ncdconnect.profile.domain.Profile
import org.ncdconnect.ncdconnect.profile.domain.ProfileRepository
import org.ncdconnect.ncdconnect.profile.domain.UpdateProfileInput
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class ProfileService(private val profileRepository: ProfileRepository) {
    fun getProfileByUserId(userId: String): Profile? = profileRepository.findByUserId(userId)

    fun updateProfile(updateProfileInput: UpdateProfileInput): Profile {
        with(updateProfileInput) {
            val existingProfile = profileRepository.findByUserId(userId) ?: Profile.createEmpty(
                userId
            )
            val updatedProfile = existingProfile.update(update)
            return profileRepository.save(updatedProfile)
        }
    }
}
