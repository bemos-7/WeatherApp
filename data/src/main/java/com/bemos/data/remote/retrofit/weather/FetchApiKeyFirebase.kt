package com.bemos.data.remote.retrofit.weather

import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.database.database
import com.google.firebase.database.getValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException


fun fetchApiKey(
    callback: (String?) -> Unit
) {
    val myRef = Firebase.database.getReference("api_key")
    myRef.get()
        .addOnSuccessListener { dataSnapshot ->
            val apiKey = dataSnapshot.getValue<String>()
            callback(apiKey)
        }
        .addOnFailureListener {
            val error = it
            Log.d("fetchApiKeyException", error.toString())
        }
}