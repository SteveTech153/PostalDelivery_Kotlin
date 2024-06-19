package com.sample.postaldelivery.system.entity.support

data class NameAddressPair(
    private val name: String,
    private val address: Address
) {
    fun getAddress(): Address {
        return address
    }
}
