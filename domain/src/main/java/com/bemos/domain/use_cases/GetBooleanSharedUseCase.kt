package com.bemos.domain.use_cases

import com.bemos.domain.repositories.LocationPreviewManagerRepository

class GetBooleanSharedUseCase(
    private val locationPreviewManagerRepository: LocationPreviewManagerRepository
) {

    fun execute(): Boolean {
        return locationPreviewManagerRepository.getLocation()
    }

}