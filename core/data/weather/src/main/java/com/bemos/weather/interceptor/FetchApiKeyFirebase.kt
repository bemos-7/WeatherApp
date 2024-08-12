package com.bemos.weather.interceptor

import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.database.database
import com.google.firebase.database.getValue


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