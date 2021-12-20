package com.emanuel.retrofit1.repository

import com.emanuel.retrofit1.network.NetworkUtils

class PostsRepository {
    suspend fun getPostsCoroutines() = NetworkUtils.service.getPostsCoroutines()
}