package com.bemos.domain.use_cases

import com.bemos.domain.repositories.IconConverterRepository

class IconConvertUseCase(
    private val iconConverterRepository: IconConverterRepository
) {

    fun execute(
        textCondition: String,
        time: Int = 5
    ) : Int {
        return iconConverterRepository.iconConvert(
            textCondition,
            time
        )
    }

}