package org.ncdconnect.ncdconnect.profile.external

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.ncdconnect.ncdconnect.profile.domain.Profile
import org.ncdconnect.ncdconnect.profile.domain.UpdateProfileInput
import org.ncdconnect.ncdconnect.profile.service.ProfileService
import org.springframework.stereotype.Component

@Component
class ProfileMutationResolver(private val profileService: ProfileService) : GraphQLMutationResolver {
    fun updateProfile(updateProfileInput: UpdateProfileInput): UpdateProfilePayload {
        return UpdateProfilePayload(
            updatedProfile = profileService.updateProfile(updateProfileInput)
        )
    }

    data class UpdateProfilePayload(
        val updatedProfile: Profile?
    )
}
