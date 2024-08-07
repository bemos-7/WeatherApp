package com.bemos.domain.use_cases

import com.bemos.city.shared_preferences_repo.LocationPreviewManagerRepository

class SetBooleanSharedUseCase(
    private val locationPreviewManagerRepository: com.bemos.city.shared_preferences_repo.LocationPreviewManagerRepository
) {

    fun execute(value: Boolean) {
        locationPreviewManagerRepository.setLocation(value)
    }

}