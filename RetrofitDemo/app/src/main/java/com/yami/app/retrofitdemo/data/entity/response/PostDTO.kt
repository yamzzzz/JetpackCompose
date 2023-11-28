package com.yami.app.retrofitdemo.data.entity.response

import com.yami.app.retrofitdemo.domain.model.Post

data class PostDTO(val id: Int, val title: String, val body: String){
    fun toDomain(): Post = Post(id, title, body)
}