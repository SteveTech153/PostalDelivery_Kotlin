package com.sample.postaldelivery.system.entity.core

import com.sample.postaldelivery.db.CustomerRepository
import com.sample.postaldelivery.db.PostOfficeRepository
import com.sample.postaldelivery.system.action.PostOfficeCustomerActions
import com.sample.postaldelivery.system.action.PostOfficeManagerActions
import com.sample.postaldelivery.system.action.PostOfficePostManActions
import com.sample.postaldelivery.system.action.PostOfficePostsActions
import com.sample.postaldelivery.system.assistance.PostalManagerAssistance
import com.sample.postaldelivery.system.entity.support.NameAddressPair
import com.sample.postaldelivery.system.entity.support.PostCard
import com.sample.postaldelivery.system.service.PostOfficeService

data class PostOffice(
    private val name: String,
    private val postOfficeRepository: PostOfficeRepository,
    private val customerRepository: CustomerRepository
):
    PostOfficePostsActions,
    PostOfficePostManActions,
    PostOfficeManagerActions,
    PostOfficeCustomerActions,
    PostalManagerAssistance
{
    companion object{
        var incrementIndex: Int = 0
    }
    private val posts: HashMap<Int, PostCard> = HashMap()
    private val statusOfDelivery: HashMap<String, String> = HashMap()
    private val customerDetails: ArrayList<NameAddressPair> = ArrayList()
    private val customersNameAddressPairAndIdMap: HashMap<NameAddressPair, Int> = HashMap()
    private val service: PostOfficeService = PostOfficeService(this, postOfficeRepository, customerRepository)
    private lateinit var manager: PostalManager
    private lateinit var postMan: PostMan

    fun getPosts(): HashMap<Int, PostCard> {
        return posts
    }

    fun setIncrementIndex(newIncrementIndexValue: Int) {
        PostOffice.incrementIndex = newIncrementIndexValue
    }

    fun getIncrementIndex(): Int {
        return PostOffice.incrementIndex
    }

    override fun getAllPosts(): MutableList<PostCard> {
        return posts.values as MutableList<PostCard>
    }

    fun setStatusOfDelivery(pId: String?, status: String?) {
        statusOfDelivery[pId!!] = status!!
    }

    fun getStatusOfDelivery(): HashMap<String, String> {
        return statusOfDelivery
    }

    fun getCustomersNameAddressPairAndIdMap(): HashMap<NameAddressPair, Int> {
        return customersNameAddressPairAndIdMap
    }

    fun getCustomersDetails(): ArrayList<NameAddressPair> {
        return customerDetails
    }

    override fun assignManager(manager: PostalManager) {
        this.manager = manager
    }

    override fun assignPostMan(postMan: PostMan) {
        this.postMan = postMan
    }

    override fun getManager(): PostalManager {
        return manager
    }

    override fun getPostMan(): PostMan {
        return postMan
    }

    override fun getIdOfACustomer(nameAddressPair: NameAddressPair): Int {
        return customersNameAddressPairAndIdMap.get(nameAddressPair)!!
    }

    override fun getStatusOfADelivery(pId: String): String {
        return statusOfDelivery.getOrDefault(pId, "Not available!")
    }

    fun addInCustomersNameAddressPairAndIdMap(nameAddressPair: NameAddressPair?, id: Int) {
        customersNameAddressPairAndIdMap[nameAddressPair!!] = id
    }

    override fun setStatusOfADelivery(pId : String, status: String) {
        if (statusOfDelivery.containsKey(pId)) {
            statusOfDelivery[pId] = status
        }
    }

    override fun doPost(post: PostCard): String {
        return service.doPost(post)
    }

    override fun registerAddress(customerDetails: NameAddressPair, id: Int): Boolean {
        return service.registerAddress(customerDetails, id)
    }

    override fun getCustomerById(id: Int): Customer? {
        return service.getCustomerById(id)
    }
}