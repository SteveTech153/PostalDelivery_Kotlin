package com.sample.postaldelivery.system.action

interface PostOfficesManagementActions {
    fun addPostOffice(city: String): Boolean
    fun removePostOffice(city: String): Boolean
    fun getAllCities(): List<String>
}