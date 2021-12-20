package com.emanuel.retrofit1.viewmodel

import androidx.lifecycle.*
import com.emanuel.retrofit1.repository.PostsRepository

class MainViewModel(private val repository: PostsRepository) : ViewModel() {

    fun getPostsCoroutines() = liveData {
        try {
            val res = repository.getPostsCoroutines()
            if (res.isSuccessful) {
                emit(Resultado.Success(listPosts = res.body()))
            } else {
                emit(Resultado.Error(messageError = res.message()))
            }
        } catch (e: Exception) {
            emit(Resultado.Error(messageError = e.message.toString()))
        }
    }

    class ViewModelFactory(private val repository: PostsRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                return MainViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}

sealed class Resultado<out R> {
    data class Success<out T>(val listPosts: T) : Resultado<T>()
    data class Error(val messageError: String) : Resultado<Nothing>()
}
