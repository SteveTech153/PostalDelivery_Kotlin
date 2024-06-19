package com.sample.postaldelivery.system.action

import com.sample.postaldelivery.system.entity.core.Customer
import com.sample.postaldelivery.system.entity.support.NameAddressPair

interface PostOfficeCustomerActions {
    fun getIdOfACustomer(nameAddressPair: NameAddressPair): Int
    fun registerAddress(customerDetails: NameAddressPair, id: Int): Boolean
    fun getCustomerById(id: Int): Customer?
}