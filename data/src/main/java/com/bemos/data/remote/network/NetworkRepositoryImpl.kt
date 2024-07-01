package com.bemos.data.remote.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.bemos.domain.repositories.NetworkRepository
import kotlinx.coroutines.flow.Flow

class NetworkRepositoryImpl(
    private val context: Context
) : NetworkRepository {
    override fun checkInternet(context: Context): Boolean {
         val connectivity = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
         if (connectivity != null) {
             val info = connectivity.allNetworkInfo
             if (info != null) {
                 info.forEach {
                     if (it.state == NetworkInfo.State.CONNECTED) {
                         return true
                     }
                 }
             }
         }
         return false
    }
}