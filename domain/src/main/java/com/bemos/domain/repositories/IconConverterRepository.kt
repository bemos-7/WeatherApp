package com.bemos.domain.repositories

interface IconConverterRepository {

    fun iconConvert(
        code: Int = 1,
        time: Int = 5
    ) : Int

}