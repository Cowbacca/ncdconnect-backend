package org.ncdconnect.ncdconnect.profile.external

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.ncdconnect.ncdconnect.profile.domain.Profile
import org.ncdconnect.ncdconnect.profile.service.ProfileService
import org.springframework.stereotype.Component

@Component
class ProfileQueryResolver(private val profileService: ProfileService) :
    GraphQLQueryResolver {
    fun getProfileById(id: String): Profile? = profileService.getProfileById(id)
}
