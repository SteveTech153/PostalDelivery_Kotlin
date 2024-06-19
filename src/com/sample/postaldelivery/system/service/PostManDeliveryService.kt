package com.sample.postaldelivery.system.service

import com.sample.postaldelivery.system.action.PostManDeliveryActions
import com.sample.postaldelivery.system.assistance.PostManAssistance
import com.sample.postaldelivery.system.entity.support.NameAddressPair
import com.sample.postaldelivery.system.entity.support.PostCard

class PostManDeliveryService( val service: PostManAssistance): PostManDeliveryActions {
    override fun doDeliveries(): String {
        val posts: List<PostCard>? = service.getAllPosts()
        return if (posts != null) {
            for(post in posts){
                val recieverId: Int = service.getIdOfACustomer(NameAddressPair(post.getRecieverName(), post.getReceiverAddress()))
                if(recieverId == -1) continue
                service.getCustomerById(recieverId).getPostBox().addPost(post)
                service.setStatusOfADelivery(post.getPId(), "success")
            }
            "Deliveries done successfully!";
        }else{
            "Something went wrong !"
        }
    }
}