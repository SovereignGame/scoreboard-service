package com.sovereign.scoreboardservice.controller

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/scoreboard-service")
class ScoreboardController() {

    //TODO Add this method
    @GetMapping("top")
    fun getTopPlayers(){
        /*
        Respons: De ti spillerne som har høyest poengskår.
        [{ username: “username1”, score: # }, … ]
         */
    }

    //TODO Add this method
    @GetMapping("/peers")
    fun getPeersForPlayerByUsername(@RequestHeader("Username") username: String){

        /*
        Respons: De fem bedre og de fire dårligere spillerne enn username.
        [{ username: “username1”, score: # }, … ]
         */
    }

    //TODO Add this method
    @PutMapping("/upadete")
    fun updatePlayerByUsername(@RequestHeader("Username") username: String){

        /*
        Intern funksjonalitet. GameInstanceService sender oppdateringer til LeaderboardService når en spillers poengsum endrer seg.
        LeaderboardService skriver dette til LeaderboardDB. Hvis username ikke er registrert oppføres en ny entry i databasen.
        Put: { score: # }
        Respons: ?
         */
    }

}