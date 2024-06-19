package com.sample.postaldelivery.system.entity.support

data class PostBox(val posts: MutableList<PostCard> = ArrayList()){
    fun addPost(post: PostCard) {
        posts.add(post)
    }
    fun getAllPosts(): List<PostCard> {
        return posts
    }
}
