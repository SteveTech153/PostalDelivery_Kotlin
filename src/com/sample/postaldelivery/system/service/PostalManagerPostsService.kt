package com.sample.postaldelivery.system.service

import com.sample.postaldelivery.db.PostOfficeRepository
import com.sample.postaldelivery.system.action.PostalManagerPostsActions
import com.sample.postaldelivery.system.assistance.PostalManagerAssistance
import com.sample.postaldelivery.system.entity.core.PostOffice
import com.sample.postaldelivery.system.entity.core.PostalManager
import com.sample.postaldelivery.system.entity.support.PostCard

class PostalManagerPostsService (
    val postalManagerCity: String,
    val postOfficeRepository: PostOfficeRepository,
    val service: PostalManagerAssistance
) :
    PostalManagerPostsActions
{
    override fun getAllPosts(): List<PostCard>? {
        return getPostsOfACity(postalManagerCity)
    }

    override fun doPost(post: PostCard): String {
        val postOffice: PostOffice? = postOfficeRepository.getAPostOfficeOfACity(post.getReceiverCity())
        postOffice?.let {
            if(post.getSenderAddress().equals(post.getReceiverAddress())){
                return "Sender and receiver address can't be same!"
            }
            return "Your post will be delivered ASAP. Here is your pId ${service.doPost(post)}"
        }?: return "Post office of your requested city is not available!"
    }

    override fun checkStatusOfAPost(pId: String): String {
        try {
            val destinationCity: String? = postOfficeRepository.getACity(pId.substring(0, 3).toInt())
            destinationCity ?: return "Post with pId $pId is not available!"

            if (destinationCity != postalManagerCity) {
                val manager: PostalManager? = postOfficeRepository.getManagerOfACity(destinationCity)
                manager?.let {
                    return "Status of your post: ${it.checkStatusOfAPost(pId)}"
                }
            } else {
                return "Status of your post: ${service.getStatusOfADelivery(pId)}"
            }
        } catch (e: Exception) {
            return "Post with pId $pId is not available!"
        }
        return "Post with pId $pId is not available!"

    }

    override fun getPostsOfACity(city: String): List<PostCard>? {
        val postOffice: PostOffice? = postOfficeRepository.getAPostOfficeOfACity(city)
        postOffice?.let{
            return it.getAllPosts()
        }?: return null
    }

    override fun setStatusOfADelivery(pId: String, status: String) {
        service.setStatusOfADelivery(pId, status)
    }
}