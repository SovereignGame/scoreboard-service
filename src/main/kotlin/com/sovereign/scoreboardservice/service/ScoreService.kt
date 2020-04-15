package com.sovereign.scoreboardservice.service

import com.sovereign.scoreboardservice.model.Score
import com.sovereign.scoreboardservice.repository.ScoreRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ScoreService(private var scoreRepository: ScoreRepository) {

    fun MutableMap<String, Int>.addUserData(score: Score?){
        if(score==null || score.total<0){
            return
        }
        this[score.username] = score.total
    }

    fun createNewScore(username: String): Boolean {
        val alreadyExist = scoreRepository.getByUsername(username)
        if(alreadyExist!=null) return false
        scoreRepository.save(Score(username))
        return true
    }
    fun createNewScore(username: String, total:Int): Boolean {
        val alreadyExist = scoreRepository.getByUsername(username)
        if(alreadyExist!=null) return false
        scoreRepository.save(Score(username,total))
        return true
    }
    fun updateScore(username: String, total:Int): Boolean {
        val score = scoreRepository.getByUsername(username)
        if(score!=null){
            scoreRepository.save(score.copy(total = total))
            return true
        }
        return createNewScore(username,total)
    }


    fun getTop10(): List<Score?>? {
        val allScores = scoreRepository.findAllByOrderByTotalDesc()
        val top10 = ArrayList<Score?>()
        for(i in 1..10){
            top10.add(allScores?.get(i))
        }
        return top10
    }
    fun getPeersForPlayerByUsername(username: String): MutableMap<String, Int> {
        val scores: MutableMap<String, Int> = HashMap()
        val allScores = scoreRepository.findAllByOrderByTotalDesc()
        var userIndex = -1;
        allScores?.forEachIndexed lit@ { index, score ->
            if(score?.username==username){
                userIndex=index
                return@lit
            }
        }
        for(i in 1..10){
            scores.addUserData(allScores?.get(userIndex-5+i))
        }
        return scores
    }
}