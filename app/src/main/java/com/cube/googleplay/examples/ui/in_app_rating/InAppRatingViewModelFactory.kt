package com.cube.googleplay.examples.ui.in_app_rating

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.play.core.review.ReviewManager

class InAppRatingViewModelFactory : ViewModelProvider.Factory {

    private val reviewManager: ReviewManager

    constructor(reviewManager: ReviewManager) {
        this.reviewManager = reviewManager
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return InAppRatingViewModel(reviewManager) as T
    }
}