package com.example.mvc_sample

import android.view.View

interface VotingView {

    /**
     * Returns the root view, i.e, the inflated layout file
     */
    fun getRootView(): View

    interface VotingActionListener {
        /**
         * Callback function which will be used by our controller to do its things fetch User Button is clicked
         */
        fun onVoteAction(president: President)
    }

    fun setListener(listener: VotingActionListener)
    fun onVoteCounted()
}