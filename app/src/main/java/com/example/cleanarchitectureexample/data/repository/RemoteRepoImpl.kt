package com.example.cleanarchitectureexample.data.repository

import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.cleanarchitectureexample.data.apiservice.ApiService
import com.example.cleanarchitectureexample.data.mappers.UserMapper
import com.example.cleanarchitectureexample.domain.model.User
import com.example.cleanarchitectureexample.domain.repository.RemoteRepo

class RemoteRepoImpl(
    private val apiService: ApiService,
    private val userMapper: UserMapper
): RemoteRepo {
    override suspend fun getUsers(): MutableList<User> {
        return apiService.getAllUsers().body()?.toMutableList()
            ?.map { userMapper.toCleanUser(it) } as MutableList<User>
    }
}