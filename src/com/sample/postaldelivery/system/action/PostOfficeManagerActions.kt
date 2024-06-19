package com.sample.postaldelivery.system.action

import com.sample.postaldelivery.system.entity.core.PostalManager

interface PostOfficeManagerActions {
    fun assignManager(manager: PostalManager)
    fun getManager(): PostalManager
}