package com.example.cleanarchitectureexample.data.repository

import com.example.cleanarchitectureexample.domain.model.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/users")
    suspend fun getAllUsers(): Response<ArrayList<User>>
}