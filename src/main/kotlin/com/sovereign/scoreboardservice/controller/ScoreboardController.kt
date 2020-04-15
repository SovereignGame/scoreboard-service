package com.sovereign.scoreboardservice.controller

import com.sovereign.scoreboardservice.model.Score
import com.sovereign.scoreboardservice.service.ScoreService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/scoreboard-service")
class ScoreboardController(private val scoreService: ScoreService) {

    @GetMapping("/top")
    fun getTopPlayers(): List<Score?>? {

        return scoreService.getTop10()
    }

    @GetMapping("/peers")
    fun getPeersForPlayerByUsername(@RequestHeader("Username") username: String):MutableMap<String,Int>{
        return scoreService.getPeersForPlayerByUsername(username)
    }

    @PutMapping("/upadete")
    fun updatePlayerByUsername(@RequestHeader("Username") username: String, @RequestParam total: Int): ResponseEntity<Boolean> {
        if(scoreService.updateScore(username, total)){
            return ResponseEntity(true,HttpStatus.OK)
        }
        return ResponseEntity(false, HttpStatus.CONFLICT)
    }

}