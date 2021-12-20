package com.emanuel.retrofit1.network

import com.emanuel.retrofit1.service.PostsService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkUtils {
        private fun getRetrofit() : Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val service: PostsService = getRetrofit().create(PostsService::class.java)
}