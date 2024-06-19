package com.sample.postaldelivery.system.entity.core

import com.sample.postaldelivery.db.PostOfficeRepository
import com.sample.postaldelivery.system.action.PostalManagerCustomerActions
import com.sample.postaldelivery.system.action.PostalManagerPostsActions
import com.sample.postaldelivery.system.entity.support.NameAddressPair
import com.sample.postaldelivery.system.entity.support.PostCard
import com.sample.postaldelivery.system.service.PasswordService
import com.sample.postaldelivery.system.service.PostalManagerService

data class PostalManager(
    override val name: String,
    private val city: String,
    private val postOfficeRepository: PostOfficeRepository,
    private val passwordService: PasswordService = PasswordService(),
    private val service: PostalManagerService = PostalManagerService(city, postOfficeRepository)
) : User(name),
    PostalManagerPostsActions,
    PostalManagerCustomerActions
{
    companion object{
        private val postalManagerPassword: String = "LfI+54Rw0CjvlghNtVkfwwbMpZPCMldkiFIyRwiyAXU="
    }

    override fun getIdOfACustomer(nameAddressPair: NameAddressPair): Int {

    }

    override fun getCustomerById(id: Int): Customer {
        TODO("Not yet implemented")
    }

    override fun getAllPosts(): List<PostCard> {
        TODO("Not yet implemented")
    }

    override fun doPost(post: PostCard): String {
        TODO("Not yet implemented")
    }

    override fun checkStatusOfAPost(pId: String): String {
        TODO("Not yet implemented")
    }

    override fun getPostsOfACity(city: String): List<PostCard> {
        TODO("Not yet implemented")
    }

    override fun setStatusOfADelivery(pId: String, status: String) {
        TODO("Not yet implemented")
    }
}