package com.emanuel.retrofit1.service

import com.emanuel.retrofit1.model.Post
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface PostsService {
    @GET("posts")
    suspend fun getPostsCoroutines(): Response<List<Post>>
}