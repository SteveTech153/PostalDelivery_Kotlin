package com.sample.postaldelivery.system.action

import com.sample.postaldelivery.system.entity.core.PostMan

interface PostOfficePostManActions {
    fun assignPostMan(postMan: PostMan)
    fun getPostMan(): PostMan
}