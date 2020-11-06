package com.example.mvc_sample

class VotingModel {
    private var trumpVoteCount = 0
    private var bidenVoteCount = 0

    fun vote(president: President) {
        when (president) {
            President.TRUMP -> trumpVoteCount++
            President.BIDEN -> bidenVoteCount++
        }
    }

    fun getVoteCount(president: President): Int {
        when (president) {
            President.TRUMP -> return trumpVoteCount
            President.BIDEN -> return bidenVoteCount
        }
    }

}