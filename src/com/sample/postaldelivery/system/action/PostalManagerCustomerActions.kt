package com.sample.postaldelivery.system.action

import com.sample.postaldelivery.system.entity.core.Customer
import com.sample.postaldelivery.system.entity.support.Address
import com.sample.postaldelivery.system.entity.support.NameAddressPair

interface PostalManagerCustomerActions {
    fun getIdOfACustomer(nameAddressPair: NameAddressPair): Int
    fun getCustomerById(id: Int): Customer?
    fun registerAddress(name: String, address: Address, id: Int): Boolean
}