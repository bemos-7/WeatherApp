package com.bemos.domain.use_cases

import android.content.Context
import com.bemos.domain.repositories.NetworkRepository

class CheckInternetUseCase(
    private val networkRepository: NetworkRepository,
    private val context: Context
) {

    fun execute() : Boolean {
        return networkRepository.checkInternet(context)
    }

}