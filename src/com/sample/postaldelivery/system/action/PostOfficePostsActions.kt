package com.sample.postaldelivery.system.action

import com.sample.postaldelivery.system.entity.support.PostCard

interface PostOfficePostsActions {
    fun doPost(post: PostCard): String
    fun getAllPosts(): List<PostCard>
    fun setStatusOfADelivery(pId: String, status: String)
    fun getStatusOfADelivery(pId: String): String
}