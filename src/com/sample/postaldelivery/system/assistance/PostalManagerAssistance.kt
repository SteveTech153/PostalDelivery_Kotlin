package com.sample.postaldelivery.system.assistance

import com.sample.postaldelivery.system.entity.core.Customer
import com.sample.postaldelivery.system.entity.support.NameAddressPair
import com.sample.postaldelivery.system.entity.support.PostCard

interface PostalManagerAssistance {
    fun doPost(post: PostCard): String
    fun getStatusOfADelivery(id: String): String
    fun getAllPosts(): List<PostCard>
    fun setStatusOfADelivery(id: String, stats: String)
    fun registerAddress(customerDetails: NameAddressPair, id: Int): Boolean
    fun getIdOfACustomer(nameAddressPair: NameAddressPair): Int
    fun getCustomerById(id: Int): Customer?
}