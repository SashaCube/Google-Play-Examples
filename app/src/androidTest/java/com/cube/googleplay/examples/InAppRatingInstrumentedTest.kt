package com.cube.googleplay.examples

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.cube.googleplay.examples.ui.in_app_rating.InAppRatingViewModel
import com.google.android.play.core.review.testing.FakeReviewManager
import io.mockk.spyk
import io.mockk.verify
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class InAppRatingInstrumentedTest {

    private lateinit var viewModel: InAppRatingViewModel

    @Test
    fun onRatingClickShouldRequestReviewInfo() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val fakeReviewManagerSpy = spyk(FakeReviewManager(appContext))

        viewModel = InAppRatingViewModel(fakeReviewManagerSpy)
        viewModel.onInAppRatingClick()

        verify { fakeReviewManagerSpy.requestReviewFlow() }
    }
}