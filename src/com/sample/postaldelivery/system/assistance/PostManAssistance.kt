package com.sample.postaldelivery.system.assistance

import com.sample.postaldelivery.system.entity.core.Customer
import com.sample.postaldelivery.system.entity.support.NameAddressPair
import com.sample.postaldelivery.system.entity.support.PostCard

interface PostManAssistance {
    fun getPostsOfACity(city: String): List<PostCard>?
    fun setStatusOfADelivery(pId: String, status: String)
    fun getIdOfACustomer(nameAddressPair: NameAddressPair): Int
    fun getCustomerById(id: Int): Customer
    fun getAllPosts(): List<PostCard>?
}