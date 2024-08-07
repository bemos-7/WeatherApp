package com.bemos.domain.use_cases

import com.bemos.city.shared_preferences_repo.LocationManagerRepository

class SetLocationSharedUseCase(
    private val locationManagerRepository: com.bemos.city.shared_preferences_repo.LocationManagerRepository
) {

    fun execute(location: String) {
        locationManagerRepository.setLocation(location)
    }

}