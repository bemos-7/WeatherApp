package com.bemos.domain.use_cases

import com.bemos.city.shared_preferences_repo.LocationPreviewManagerRepository

class GetBooleanSharedUseCase(
    private val locationPreviewManagerRepository: com.bemos.city.shared_preferences_repo.LocationPreviewManagerRepository
) {

    fun execute(): Boolean {
        return locationPreviewManagerRepository.getLocation()
    }

}