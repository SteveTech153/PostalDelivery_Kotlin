package com.sample.postaldelivery.system.service

import com.sample.postaldelivery.system.action.CustomerPostsActions
import com.sample.postaldelivery.system.assistance.CustomerAssistance
import com.sample.postaldelivery.system.entity.support.PostBox
import com.sample.postaldelivery.system.entity.support.PostCard

class CustomerPostsService( val service: CustomerAssistance ): CustomerPostsActions {
    override fun doPost(post: PostCard): String {
        return service.doPost(post)
    }

    override fun checkStatusOfAPost(pId: String): String {
        return service.checkStatusOfAPost(pId)
    }

    fun checkAllPosts(postBox: PostBox) {
        for (post in postBox.getAllPosts()) {
            println(post)
        }
        if (postBox.getAllPosts().isEmpty()) {
            println("No posts yet!")
        }
    }
}