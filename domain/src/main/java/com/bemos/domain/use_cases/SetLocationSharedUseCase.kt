package com.bemos.domain.use_cases

import com.bemos.domain.repositories.LocationManagerRepository

class SetLocationSharedUseCase(
    private val locationManagerRepository: LocationManagerRepository
) {

    fun execute(location: String) {
        locationManagerRepository.setLocation(location)
    }

}