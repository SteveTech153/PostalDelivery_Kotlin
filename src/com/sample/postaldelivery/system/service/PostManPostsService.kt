package com.sample.postaldelivery.system.service

import com.sample.postaldelivery.system.action.PostManPostsActions
import com.sample.postaldelivery.system.assistance.PostManAssistance
import com.sample.postaldelivery.system.entity.support.PostCard

class PostManPostsService(val service: PostManAssistance): PostManPostsActions {
    override fun printAllPosts() {
        val posts: List<PostCard> = service.getAllPosts()
        for(post in posts){
            println("Post id : $post.getPId() , Sender City : $post.getSenderCity() , Receiver City : $post.getReceiverCity()")
        }
        if(posts.size == 0)
            println("No posts to deliver!")
    }
}