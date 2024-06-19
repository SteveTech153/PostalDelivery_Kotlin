package com.sample.postaldelivery.system.service

import com.sample.postaldelivery.system.action.PostManDeliveryActions
import com.sample.postaldelivery.system.action.PostManPostsActions
import com.sample.postaldelivery.system.assistance.PostManAssistance
import com.sample.postaldelivery.system.entity.core.Customer
import com.sample.postaldelivery.system.entity.support.NameAddressPair
import com.sample.postaldelivery.system.entity.support.PostCard

class PostManService(
    val service: PostManAssistance,
    val postsService: PostManPostsService = PostManPostsService(service),
    val deliveryService: PostManDeliveryService = PostManDeliveryService(service)
) : PostManPostsActions, PostManDeliveryActions {
    override fun printAllPosts() {
        postsService.printAllPosts()
    }

    override fun doDeliveries(): String {
        return deliveryService.doDeliveries()
    }

}