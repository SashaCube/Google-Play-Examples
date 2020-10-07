package com.cube.googleplay.examples.di

import android.content.Context
import com.google.android.play.core.review.ReviewManager
import com.google.android.play.core.review.ReviewManagerFactory

object DependenciesManager {

    private var context: Context? = null
    private var reviewManager: ReviewManager? = null

    fun init(context: Context) {
        this.context = context
    }

    fun getReviewManager(): ReviewManager {
        if (context == null) {
            throw DependenciesNotInitializedException()
        }

        if (reviewManager == null) {
            reviewManager = ReviewManagerFactory.create(context)
        }

        return reviewManager as ReviewManager
    }

}