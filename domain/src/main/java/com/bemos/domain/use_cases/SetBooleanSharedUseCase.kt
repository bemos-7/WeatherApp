package com.bemos.domain.use_cases

import com.bemos.domain.repositories.LocationPreviewManagerRepository

class SetBooleanSharedUseCase(
    private val locationPreviewManagerRepository: LocationPreviewManagerRepository
) {

    fun execute(value: Boolean) {
        locationPreviewManagerRepository.setLocation(value)
    }

}