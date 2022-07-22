package com.example.cleanarchitectureexample.data.mappers

import com.example.cleanarchitectureexample.data.models.UserModel
import com.example.cleanarchitectureexample.domain.model.User

class UserMapper {
    fun toCleanUser(userModelServer: UserModel): User {
        return User(
            userModelServer.id,
            userModelServer.name,
            userModelServer.username,
            userModelServer.email,
            userModelServer.phone,
            userModelServer.website
        )
    }
}