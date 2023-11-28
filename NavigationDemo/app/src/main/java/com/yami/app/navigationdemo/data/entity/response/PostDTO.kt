package com.yami.app.navigationdemo.data.entity.response

import com.yami.app.navigationdemo.domain.model.Post

data class PostDTO(val id: Int, val title: String, val body: String){
    fun toDomain(): Post = Post(id, title, body)
}