package com.sample.postaldelivery.system.service

import com.sample.postaldelivery.system.assistance.CustomerAssistance
import com.sample.postaldelivery.system.entity.support.Address
import com.sample.postaldelivery.system.entity.support.PostBox
import com.sample.postaldelivery.system.entity.support.PostCard

class CustomerService(val service: CustomerAssistance, val postsService: CustomerPostsService = CustomerPostsService(service), val personalDetailsService: CustomerPersonalDetailsService = CustomerPersonalDetailsService(service)): CustomerAssistance() {
    override fun doPost(post: PostCard): String {
        return postsService.doPost(post)
    }

    override fun checkStatusOfAPost(pId: String): String {
        return service.checkStatusOfAPost(pId)
    }

    fun checkAllPosts(postBox: PostBox) {
        postsService.checkAllPosts(postBox)
    }

    override fun registerAddress(name: String, address: Address, id: Int): Boolean {
        return personalDetailsService.registerAddress(name, address, id)
    }

}