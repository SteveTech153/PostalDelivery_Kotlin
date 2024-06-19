package com.sample.postaldelivery.db

import com.sample.postaldelivery.system.entity.core.Customer

interface CustomerRepository {
    fun getCustomerById(id: Int): Customer?
    fun getCustomerByAadhar(aadharNumber: String): Customer?
    fun addCustomer(customer: Customer): Boolean
}