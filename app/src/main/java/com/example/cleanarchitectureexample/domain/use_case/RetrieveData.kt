package com.example.cleanarchitectureexample.domain.use_case

import com.example.cleanarchitectureexample.domain.model.User
import com.example.cleanarchitectureexample.domain.repository.RemoteRepo

interface SingleUseCase {
    suspend fun execute(): MutableList<User>
}

class GetUsersInfoUseCase(
    private val apiRepo: RemoteRepo
): SingleUseCase {
    override suspend fun execute(): MutableList<User> {
        return apiRepo.getUsers()
    }
}