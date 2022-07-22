package com.example.cleanarchitectureexample.domain.model

import com.google.gson.annotations.SerializedName

data class User(
    var id: Int,
    var name: String,
    var username: String,
    var email: String,
    var phone: String,
    var website: String
)
