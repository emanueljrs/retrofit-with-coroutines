package com.emanuel.retrofit1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.emanuel.retrofit1.databinding.PostItemBinding
import com.emanuel.retrofit1.model.Post

class PostAdapter(private val listPost: List<Post>) : RecyclerView.Adapter<PostAdapter.PostsViewHolder>() {

    private lateinit var binding: PostItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        binding = PostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.bind(listPost[position])
    }

    override fun getItemCount(): Int = listPost.size

    class PostsViewHolder(binding: PostItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val title = binding.textTittle
        private val userId = binding.textUserId
        private val id = binding.textId
        private val body = binding.textBody

        fun bind(post: Post) {
            title.text = post.title
            userId.text = post.userId.toString()
            id.text = post.id.toString()
            body.text = post.body
        }
    }

}