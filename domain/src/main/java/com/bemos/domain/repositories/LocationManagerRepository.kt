package com.bemos.domain.repositories

interface LocationManagerRepository {

    fun setLocation(location: String)

    fun getLocation(): String

}