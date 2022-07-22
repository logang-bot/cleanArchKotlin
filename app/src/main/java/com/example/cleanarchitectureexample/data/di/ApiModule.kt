package com.example.cleanarchitectureexample.data.di

import com.example.cleanarchitectureexample.data.apiservice.ApiService
import retrofit2.Retrofit

class ApiModule {
    companion object {
        fun bindApiService(retrofit: Retrofit): ApiService {
            return retrofit.create(ApiService::class.java)
        }
    }
}