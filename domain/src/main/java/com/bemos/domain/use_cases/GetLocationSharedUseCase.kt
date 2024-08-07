package com.bemos.domain.use_cases

import com.bemos.city.shared_preferences_repo.LocationManagerRepository

class GetLocationSharedUseCase(
    private val locationManagerRepository: com.bemos.city.shared_preferences_repo.LocationManagerRepository
) {

    fun execute(): String {
        return locationManagerRepository.getLocation()
    }

}