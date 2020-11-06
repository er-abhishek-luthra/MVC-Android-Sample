package com.example.mvc_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class VotingActivity : AppCompatActivity(), VotingView.VotingActionListener {
    private lateinit var mVotingView: VotingView
    private lateinit var mVotingModel: VotingModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mVotingModel = VotingModel()
        mVotingView = VotingViewImp(layoutInflater, mVotingModel)
        mVotingView.setListener(this)
        setContentView(mVotingView.getRootView())
    }

    override fun onVoteAction(president: President) {
        mVotingModel.vote(president)
        mVotingView.onVoteCounted()

    }
}