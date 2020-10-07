package com.cube.googleplay.examples.ui.in_app_rating

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.play.core.review.ReviewInfo
import com.google.android.play.core.review.ReviewManager

class InAppRatingViewModel(
    private val reviewManager: ReviewManager
) : ViewModel() {

    private val _reviewInfo = MutableLiveData<ReviewInfo>()

    val reviewInfo: LiveData<ReviewInfo> = _reviewInfo

    fun onInAppRatingClick() {
        val request = reviewManager.requestReviewFlow()
        request.addOnCompleteListener { request ->
            if (request.isSuccessful) {
                _reviewInfo.postValue(request.result)
            } else {
                // There was some problem, continue regardless of the result.
            }
        }

    }
}