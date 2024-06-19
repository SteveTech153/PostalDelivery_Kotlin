package com.sample.postaldelivery.system.action

import com.sample.postaldelivery.system.entity.support.Address

interface CustomerPersonalDetailsActions {
    fun registerAddress(name: String, address: Address, id: Int): Boolean
}