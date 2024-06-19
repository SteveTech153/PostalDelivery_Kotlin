package com.sample.postaldelivery.db

import com.sample.postaldelivery.system.entity.core.Customer

object CustomersDB :
    CustomerRepository
{
    val customersAadharMap: HashMap<String, Customer> = HashMap()
    val customerIdMap: HashMap<Int, Customer> = HashMap()
    override fun getCustomerById(id: Int): Customer? {
        return customerIdMap.getOrDefault(id, null)
    }

    override fun getCustomerByAadhar(aadharNumber: String): Customer? {
        return customersAadharMap.getOrDefault(aadharNumber, null)
    }

    override fun addCustomer(customer: Customer): Boolean {
        val aadharAdded = customersAadharMap.putIfAbsent(customer.aadharNumber, customer) == null
        val idAdded = customerIdMap.putIfAbsent(customer.id, customer) == null
        return aadharAdded && idAdded
    }
}