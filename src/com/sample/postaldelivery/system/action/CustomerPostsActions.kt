package com.sample.postaldelivery.system.action

import com.sample.postaldelivery.system.entity.support.PostBox
import com.sample.postaldelivery.system.entity.support.PostCard

interface CustomerPostsActions {
    fun doPost(post: PostCard): String
    fun checkStatusOfAPost(pId: String): String
}