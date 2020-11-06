package com.example.mvc_sample

import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView

class VotingViewImp(layoutInflater: LayoutInflater, private val mVotingModel: VotingModel) : VotingView {
    private var mRootView = layoutInflater.inflate(R.layout.activity_voting, null)
    private var votingActionListener: VotingView.VotingActionListener? = null
    private lateinit var mBtnVoteTrump: Button
    private lateinit var mBtnVoteBiden: Button
    private lateinit var mTvVoteCount: TextView

    init {
        mRootView?.apply {
            mBtnVoteTrump = findViewById(R.id.btn_vote_trump)
            mBtnVoteBiden = findViewById(R.id.btn_vote_biden)
            mTvVoteCount = findViewById(R.id.tv_vote_count_details)
        }
        mBtnVoteTrump.setOnClickListener {
            votingActionListener?.onVoteAction(President.TRUMP)

        }
        mBtnVoteBiden.setOnClickListener {
            votingActionListener?.onVoteAction(President.BIDEN)
        }
    }

    @Override
    override fun getRootView(): View = mRootView

    @Override
    override fun setListener(listener: VotingView.VotingActionListener) {
        votingActionListener = listener
    }

    override fun onVoteCounted() {
        val trumpVote = mVotingModel.getVoteCount(President.TRUMP)
        val bidenVote = mVotingModel.getVoteCount(President.BIDEN)
        val trumpVoteString = """${President.TRUMP.name} : $trumpVote"""
        val bidenVoteString = """${President.BIDEN.name} : $bidenVote"""
        val voteCountDetails = """$trumpVoteString   $bidenVoteString"""
        mTvVoteCount.text = voteCountDetails
    }
}