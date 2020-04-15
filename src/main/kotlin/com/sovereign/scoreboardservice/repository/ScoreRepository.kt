package com.sovereign.scoreboardservice.repository

import com.sovereign.scoreboardservice.model.Score
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ScoreRepository : JpaRepository<Score, String>{
    fun getByUsername(username: String):Score?

    fun findAllByOrderByTotalDesc():List<Score?>?



}