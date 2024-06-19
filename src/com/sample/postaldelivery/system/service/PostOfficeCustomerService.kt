package com.sample.postaldelivery.system.service

import com.sample.postaldelivery.db.CustomerRepository
import com.sample.postaldelivery.system.entity.core.Customer
import com.sample.postaldelivery.system.entity.core.PostOffice
import com.sample.postaldelivery.system.entity.support.NameAddressPair

class PostOfficeCustomerService(
    val postOffice: PostOffice,
    val customerRepository: CustomerRepository
) {
    fun addCustomer(customerDetails: NameAddressPair, id: Int): Boolean {
        if (!this.postOffice.getCustomersDetails().contains(customerDetails)) {
            postOffice.getCustomersDetails().add(customerDetails)
            addInCustomersNameAddressPairAndIdMap(customerDetails, id)
            customerRepository.getCustomerById(id)?.setAddress(customerDetails.getAddress())
            return true
        }
        return false
    }
    fun addInCustomersNameAddressPairAndIdMap(nameAddressPair: NameAddressPair?, id: Int) {
        postOffice.getCustomersNameAddressPairAndIdMap()[nameAddressPair!!] = id
    }

    fun getCustomerById(id: Int): Customer? {
        return customerRepository.getCustomerById(id)
    }
}