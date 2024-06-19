package com.sample.postaldelivery.system.service

import com.sample.postaldelivery.system.action.PostalManagerCustomerActions
import com.sample.postaldelivery.system.assistance.PostalManagerAssistance
import com.sample.postaldelivery.system.entity.core.Customer
import com.sample.postaldelivery.system.entity.support.Address
import com.sample.postaldelivery.system.entity.support.NameAddressPair

class PostalManagerCustomerService(
    val service: PostalManagerAssistance
) :
    PostalManagerCustomerActions
{
    override fun getIdOfACustomer(nameAddressPair: NameAddressPair): Int {
        return service.getIdOfACustomer(nameAddressPair)
    }

    override fun getCustomerById(id: Int): Customer? {
        return service.getCustomerById(id)
    }

    override fun registerAddress(name: String, address: Address, id: Int): Boolean {
        return service.registerAddress(NameAddressPair(name, address), id)
    }
}