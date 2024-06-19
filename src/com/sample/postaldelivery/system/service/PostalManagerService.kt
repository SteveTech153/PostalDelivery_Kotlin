package com.sample.postaldelivery.system.service

import com.sample.postaldelivery.db.PostOfficeRepository
import com.sample.postaldelivery.system.action.PostalManagerCustomerActions
import com.sample.postaldelivery.system.action.PostalManagerPostsActions
import com.sample.postaldelivery.system.assistance.CustomerAssistance
import com.sample.postaldelivery.system.assistance.PostManAssistance
import com.sample.postaldelivery.system.assistance.PostalManagerAssistance
import com.sample.postaldelivery.system.entity.core.Customer
import com.sample.postaldelivery.system.entity.support.Address
import com.sample.postaldelivery.system.entity.support.NameAddressPair
import com.sample.postaldelivery.system.entity.support.PostBox
import com.sample.postaldelivery.system.entity.support.PostCard

class PostalManagerService (
    val city: String,
    val postOfficeRepository: PostOfficeRepository,
    val service: PostalManagerAssistance,
    val postsService: PostalManagerPostsService = PostalManagerPostsService(city, postOfficeRepository, service),
    val customerActionService: PostalManagerCustomerService = PostalManagerCustomerService(service)
) :
    CustomerAssistance(),
    PostManAssistance,
    PostalManagerPostsActions,
    PostalManagerCustomerActions
{
    override fun getAllPosts(): List<PostCard>? {
        return postsService.getAllPosts()
    }

    override fun doPost(post: PostCard): String {
        return postsService.doPost(post)
    }

    override fun checkStatusOfAPost(pId: String): String {
        return postsService.checkStatusOfAPost(pId)
    }

    override fun registerAddress(name: String, address: Address, id: Int): Boolean {
        return customerActionService.registerAddress(name, address, id)
    }

    override fun getPostsOfACity(city: String): List<PostCard>? {
        return postsService.getPostsOfACity(city)
    }

    override fun setStatusOfADelivery(pId: String, status: String) {
        postsService.setStatusOfADelivery(pId, status)
    }

    override fun getIdOfACustomer(nameAddressPair: NameAddressPair): Int {
        return customerActionService.getIdOfACustomer(nameAddressPair)
    }

    override fun getCustomerById(id: Int): Customer {
        return customerActionService.getCustomerById(id)
    }
}