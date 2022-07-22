package com.example.cleanarchitectureexample.data.models

import com.google.gson.annotations.SerializedName

data class UserModel (
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("username")
    var username: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("phone")
    var phone: String,
    @SerializedName("website")
    var website: String
)