package com.sample.postaldelivery.db

import com.sample.postaldelivery.system.entity.core.PostOffice
import com.sample.postaldelivery.system.entity.core.PostalManager

interface PostOfficeRepository {
    fun getAPostOfficeOfACity(city: String): PostOffice?
    fun getACity(id: Int): String
    fun getManagerOfACity(city: String): PostalManager?
    fun getIndexOfCity(city: String): Int
}