package com.bemos.domain.repositories

interface LocationPreviewManagerRepository {

    fun setLocation(value: Boolean)

    fun getLocation(): Boolean

}