package com.sample.postaldelivery.system.service

import com.sample.postaldelivery.db.PostOfficesDB
import com.sample.postaldelivery.db.PostOfficesDB.addCity
import com.sample.postaldelivery.db.PostOfficesDB.createPostOffice
import com.sample.postaldelivery.db.PostOfficesDB.getAPostOfficeOfACity
import com.sample.postaldelivery.db.PostOfficesDB.getManagerOfACity
import com.sample.postaldelivery.system.action.PostOfficesManagementActions
import com.sample.postaldelivery.system.entity.core.PostMan
import com.sample.postaldelivery.system.entity.core.PostOffice
import com.sample.postaldelivery.system.entity.core.PostalManager


class PostOfficesManagementService(

):
    PostOfficesManagementActions
{
    override fun addPostOffice(city: String): Boolean {
        val cityLowerCase = city.lowercase()
        var added = true
        added = added && addCity(cityLowerCase)
        added = added && createPostOffice(cityLowerCase, PostOffice("$cityLowerCase office"))
        try {
            if (added) {
                getAPostOfficeOfACity(city)!!
                    .assignManager(PostalManager("$city manager", "Postalmanager@123", cityLowerCase))
            }
            val postalManagerPostmanService: PostalManagerPostmanAssistance? = getManagerOfACity(cityLowerCase)
            val postMan = PostMan("$city post man", "Postman@123", cityLowerCase, PostManService(postalManagerPostmanService))
            added = added && PostOfficesDB.addPostManAndCity(postMan, cityLowerCase)
            getAPostOfficeOfACity(cityLowerCase)!!.assignPostMan(postMan)
        } catch (e: Exception) {
            return false
        }
        return added
    }

    override fun removePostOffice(city: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun getAllCities(): List<String> {
        TODO("Not yet implemented")
    }

}