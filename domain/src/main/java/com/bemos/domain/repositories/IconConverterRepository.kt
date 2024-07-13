package com.bemos.domain.repositories

interface IconConverterRepository {

    fun iconConvert(
        textCondition: String,
        time: Int = 5
    ) : Int

}