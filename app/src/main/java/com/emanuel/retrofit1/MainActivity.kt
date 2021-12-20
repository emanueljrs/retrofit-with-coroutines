package com.emanuel.retrofit1

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.emanuel.retrofit1.adapter.PostAdapter
import com.emanuel.retrofit1.databinding.ActivityMainBinding
import com.emanuel.retrofit1.repository.PostsRepository
import com.emanuel.retrofit1.viewmodel.MainViewModel
import com.emanuel.retrofit1.viewmodel.Resultado
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels {
        MainViewModel.ViewModelFactory(PostsRepository())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setObservers()
    }

    private fun setObservers() {
        var postAdapter: PostAdapter
        viewModel.getPostsCoroutines().observe(this) { result ->
            when(result) {
                is Resultado.Success -> {
                    result.listPosts?.let {
                        postAdapter = PostAdapter(result.listPosts)

                        with(binding.rvPosts) {
                            setHasFixedSize(true)
                            layoutManager = LinearLayoutManager(this@MainActivity)
                            adapter = postAdapter
                        }
                    }
                }
                is Resultado.Error -> {
                    Snackbar.make(binding.root, "Error", Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }
}