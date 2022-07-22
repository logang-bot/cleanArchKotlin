package com.example.cleanarchitectureexample.domain.repository

import com.example.cleanarchitectureexample.domain.model.User

interface RemoteRepo {
    suspend fun getUsers(): MutableList<User>
}