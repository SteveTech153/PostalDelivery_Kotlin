package com.sample.postaldelivery.system.action

import com.sample.postaldelivery.system.entity.support.PostCard

interface PostalManagerPostsActions {
    fun getAllPosts(): List<PostCard>?
    fun doPost(post: PostCard): String
    fun checkStatusOfAPost(pId: String): String
    fun getPostsOfACity(city: String): List<PostCard>?
    fun setStatusOfADelivery(pId: String, status: String)
}