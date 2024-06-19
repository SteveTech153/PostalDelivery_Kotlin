package com.sample.postaldelivery.system.service

import com.sample.postaldelivery.db.PostOfficeRepository
import com.sample.postaldelivery.system.action.PostOfficePostsActions
import com.sample.postaldelivery.system.entity.core.PostOffice
import com.sample.postaldelivery.system.entity.support.PostCard

class PostOfficePostsService(
    val postOffice: PostOffice,
    val postOfficeRepository: PostOfficeRepository
)
{
    fun doPost(post: PostCard): String {
        val cityId: Int = postOfficeRepository.getIndexOfCity(post.getReceiverCity())
        val lengthOfCityId: Int = cityId.toString().length
        if(lengthOfCityId==1){
            postOffice.setIncrementIndex(postOffice.getIncrementIndex()+1)
            post.setPId("00${cityId}${postOffice.getIncrementIndex()}")
        }else if(lengthOfCityId==2){
            postOffice.setIncrementIndex(postOffice.getIncrementIndex()+1);
            post.setPId("0$cityId${postOffice.getIncrementIndex()}")
        }else{
            postOffice.setIncrementIndex(postOffice.getIncrementIndex()+1);
            post.setPId("$cityId${postOffice.getIncrementIndex()}")
        }
        postOffice.getPosts().put(postOffice.getIncrementIndex(), post);
        postOffice.setStatusOfDelivery(post.getPId(), "Not delivered yet!");
        return post.getPId();
    }
}