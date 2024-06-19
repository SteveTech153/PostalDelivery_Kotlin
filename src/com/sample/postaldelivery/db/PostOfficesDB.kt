package com.sample.postaldelivery.db

import com.sample.postaldelivery.system.entity.core.PostMan
import com.sample.postaldelivery.system.entity.core.PostOffice
import com.sample.postaldelivery.system.entity.core.PostalManager

object PostOfficesDB:
    PostOfficeRepository
{
    val cities: ArrayList<String> = ArrayList()
    val cityPostOfficeMap: HashMap<String, PostOffice> = HashMap<String, PostOffice>()
    val postManCityMap: HashMap<PostMan, String> = HashMap<PostMan, String>()
    override fun getAPostOfficeOfACity(city: String): PostOffice? {
        return cityPostOfficeMap.getOrDefault(city, null)
    }
    fun addCity(city: String): Boolean {
        return if (!cities.contains(city.lowercase())) {
            cities.add(city.lowercase())
            true
        } else {
            false
        }
    }
    override fun getACity(id: Int): String {
        return cities[id]
    }
    fun createPostOffice(city: String, postOffice: PostOffice): Boolean {
        cityPostOfficeMap[city] = postOffice
        return cityPostOfficeMap.containsKey(city)
    }
    fun getCities(): List<String> {
        return cities
    }

    override fun getManagerOfACity(city: String): PostalManager? {
        return if(getCities().contains(city))
            getAPostOfficeOfACity(city)?.getManager()
        else
            null
    }

    override fun getIndexOfCity(city: String): Int {
        return cities.indexOf(city)
    }
}
