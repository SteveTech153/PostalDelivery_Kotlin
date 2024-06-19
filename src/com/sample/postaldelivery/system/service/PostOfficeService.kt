package com.sample.postaldelivery.system.service

import com.sample.postaldelivery.db.CustomerRepository
import com.sample.postaldelivery.db.PostOfficeRepository
import com.sample.postaldelivery.system.assistance.PostalManagerAssistance
import com.sample.postaldelivery.system.entity.core.Customer
import com.sample.postaldelivery.system.entity.core.PostOffice
import com.sample.postaldelivery.system.entity.support.NameAddressPair
import com.sample.postaldelivery.system.entity.support.PostCard

class PostOfficeService (
    val postOffice: PostOffice,
    val postOfficeRepository: PostOfficeRepository,
    val customerRepository: CustomerRepository,
    val postsService: PostOfficePostsService = PostOfficePostsService(postOffice, postOfficeRepository),
    val customerService: PostOfficeCustomerService = PostOfficeCustomerService(postOffice, customerRepository)
)
{
    fun doPost(post: PostCard): String {
    return postsService.doPost(post)
    }
    fun registerAddress(customerDetails: NameAddressPair, id: Int): Boolean {
        return customerService.addCustomer(customerDetails, id)
    }
    fun getCustomerById(id: Int): Customer? {
        return customerService.getCustomerById(id)
    }
}