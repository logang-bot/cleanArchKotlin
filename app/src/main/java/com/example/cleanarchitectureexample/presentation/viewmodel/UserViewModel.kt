package com.example.cleanarchitectureexample.presentation.viewmodel

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.cleanarchitectureexample.data.apiservice.ApiService
import com.example.cleanarchitectureexample.data.di.ApiModule
import com.example.cleanarchitectureexample.data.mappers.UserMapper
import com.example.cleanarchitectureexample.data.models.UserModel
import com.example.cleanarchitectureexample.data.remote.RetrofitClient
import com.example.cleanarchitectureexample.data.repository.ApiInterface
import com.example.cleanarchitectureexample.data.repository.RemoteRepoImpl
import com.example.cleanarchitectureexample.domain.model.User
import com.example.cleanarchitectureexample.domain.use_case.GetUsersInfoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserViewModel : AppCompatActivity()  {
    var retrofit = RetrofitClient.getInstance()
    var apiService = ApiModule.bindApiService(retrofit)
    var userMapperInst = UserMapper()

    val remoteRepoImpl = RemoteRepoImpl(apiService, userMapperInst)
    val getUseCase = GetUsersInfoUseCase(remoteRepoImpl)
    var usersList = mutableListOf<User>()


    fun getUsersDataFromApi( completion: () -> Unit) {
        GlobalScope.launch {
            usersList = getUseCase.execute()
            withContext(Dispatchers.Main) {
                completion()
            }
        }
    }
}