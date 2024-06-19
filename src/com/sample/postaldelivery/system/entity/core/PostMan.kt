package com.sample.postaldelivery.system.entity.core

import com.sample.postaldelivery.system.action.PostManDeliveryActions
import com.sample.postaldelivery.system.action.PostManPostsActions
import com.sample.postaldelivery.system.service.PasswordService
import com.sample.postaldelivery.system.service.PostManService

data class PostMan(
    override val name: String,
    private val city: String,
    private val service: PostManService,
    private val passwordService: PasswordService = PasswordService()
): User(name),
    PostManPostsActions,
    PostManDeliveryActions
{
    private val id = ++idIndex
    companion object{
        private var idIndex: Int = 0
    }

    override fun printAllPosts() {
        service.printAllPosts()
    }

    override fun doDeliveries(): String {
        return service.doDeliveries()
    }
}
