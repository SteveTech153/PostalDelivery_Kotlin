package com.sample.postaldelivery.system.entity.core

import com.sample.postaldelivery.system.action.CustomerPersonalDetailsActions
import com.sample.postaldelivery.system.action.CustomerPostsActions
import com.sample.postaldelivery.system.entity.support.Address
import com.sample.postaldelivery.system.entity.support.PostBox
import com.sample.postaldelivery.system.entity.support.PostCard
import com.sample.postaldelivery.system.service.CustomerService

class Customer(
    name: String,
    val aadharNumber: String,
    val service: CustomerService
) : User(name), CustomerPostsActions, CustomerPersonalDetailsActions {

    val id: Int = ++indexIncrement
    private var address: Address? = null
    private val postBox: PostBox = PostBox()

    companion object {
        private var indexIncrement: Int = 0
    }

    override fun doPost(post: PostCard): String {
        return service.doPost(post)
    }

    override fun checkStatusOfAPost(pId: String): String {
        return service.checkStatusOfAPost(pId)
    }
    fun setAddress(address: Address){
        this.address = address
    }
    fun checkAllPosts(postBox: PostBox) {
        service.checkAllPosts(postBox)
    }

    override fun registerAddress(name: String, address: Address, id: Int): Boolean {
        return service.registerAddress(name, address, id)
    }
    fun getPostBox(): PostBox{
        return postBox
    }
}
