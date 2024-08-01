package com.bemos.domain.use_cases

import com.bemos.domain.repositories.LocationManagerRepository

class GetLocationSharedUseCase(
    private val locationManagerRepository: LocationManagerRepository
) {

    fun execute(): String {
        return locationManagerRepository.getLocation()
    }

}