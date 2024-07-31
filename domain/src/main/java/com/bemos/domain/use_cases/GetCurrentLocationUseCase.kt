package com.bemos.domain.use_cases

import com.bemos.domain.repositories.CurrentLocationRepository

class GetCurrentLocationUseCase(
    private val currentLocationRepository: CurrentLocationRepository
) {

    fun execute(currentLocation: (String?) -> Unit) {
        currentLocationRepository.getCurrentLocation {
            currentLocation(it)
        }
    }

}