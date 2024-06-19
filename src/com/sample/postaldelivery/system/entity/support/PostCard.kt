package com.sample.postaldelivery.system.entity.support

data class PostCard(
    private val from: Address,
    private val to: Address,
    private val message: String,
    private var pId: String
){
    fun getSenderCity(): String {
        return from.city
    }

    fun getReceiverCity(): String {
        return to.city
    }

    fun getRecieverName(): String {
        return to.name
    }

    override fun toString(): String {
        return "From: $from\nTo: $to\nMessage: $message"
    }

    fun getSenderAddress(): Address {
        return from
    }

    fun getReceiverAddress(): Address {
        return to
    }

    fun getPId(): String {
        return pId
    }

    fun setPId(id: String) {
        pId = id
    }
}


