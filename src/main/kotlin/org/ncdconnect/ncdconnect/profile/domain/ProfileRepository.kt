package org.ncdconnect.ncdconnect.profile.domain

import org.springframework.data.repository.Repository

interface ProfileRepository :
    Repository<Profile, String> {
    fun save(profile: Profile): Profile

    fun findById(id: String): Profile?
}
