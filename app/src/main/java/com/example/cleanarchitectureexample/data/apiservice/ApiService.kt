package com.example.cleanarchitectureexample.data.apiservice

import com.example.cleanarchitectureexample.data.models.UserModel
import com.example.cleanarchitectureexample.domain.model.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/users")
    suspend fun getAllUsers(): Response<ArrayList<UserModel>>
}