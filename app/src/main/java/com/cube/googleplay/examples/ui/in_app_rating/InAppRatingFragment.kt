package com.cube.googleplay.examples.ui.in_app_rating

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.cube.googleplay.examples.R
import com.cube.googleplay.examples.di.DependenciesManager

/**
 * You can use internal app sharing to test your integration with In-App Review API.
 * Don't forgot to verify applicationID, also app should be already published.
 *
 * @see <a href="https://play.google.com/apps/publish/internalappsharing/">Internal app sharing</a>
 * @see <a href="https://developer.android.com/guide/playcore/in-app-review/test">Test in-app reviews</a>
 */
class InAppRatingFragment : Fragment() {

    private val inAppRatingViewModel: InAppRatingViewModel by viewModels {
        InAppRatingViewModelFactory(DependenciesManager.getReviewManager())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_in_app_rating, container, false)

        initRatingButton(root)
        initReviewInfoObserver()

        return root
    }

    private fun initRatingButton(root: View) {
        val btnInAppRating: Button = root.findViewById(R.id.btnInAppRating)
        btnInAppRating.setOnClickListener {
            inAppRatingViewModel.onInAppRatingClick()
        }
    }

    private fun initReviewInfoObserver() {
        inAppRatingViewModel.reviewInfo.observe(viewLifecycleOwner, { reviewInfo ->
            val flow = DependenciesManager.getReviewManager().launchReviewFlow(activity, reviewInfo)
            flow.addOnCompleteListener {
                // The flow has finished. The API does not indicate whether the user
                // reviewed or not, or even whether the review dialog was shown. Thus, no
                // matter the result, we continue our app flow.
                Toast.makeText(context, "in app review flow completed", Toast.LENGTH_LONG).show()
            }
        })
    }
}