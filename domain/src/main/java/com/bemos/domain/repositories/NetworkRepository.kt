package com.bemos.domain.repositories

import android.content.Context

interface NetworkRepository {

    fun checkInternet(context: Context): Boolean

}