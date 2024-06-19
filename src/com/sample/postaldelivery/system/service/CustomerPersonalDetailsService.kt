package com.sample.postaldelivery.system.service

import com.sample.postaldelivery.system.action.CustomerPersonalDetailsActions
import com.sample.postaldelivery.system.assistance.CustomerAssistance
import com.sample.postaldelivery.system.entity.support.Address

class CustomerPersonalDetailsService (val service: CustomerAssistance): CustomerPersonalDetailsActions {
    override fun registerAddress(name: String, address: Address, id: Int): Boolean {
        return service.registerAddress(name, address, id)
    }
}