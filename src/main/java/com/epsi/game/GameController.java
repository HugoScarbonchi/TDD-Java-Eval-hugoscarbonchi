package com.epsi.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameScore gameScore;

    @Autowired
    public GameController(GameScore gameScore) {
        this.gameScore = gameScore;
    }

    @GetMapping("/game/play/{action}")
    public String playGame(@PathVariable String action) {
        String[] actions = {"pierre", "feuille", "ciseaux"};
        String computerAction = actions[new Random().nextInt(actions.length)];
        String result;
        if (action.equals(computerAction)) {
            result = "fait égalité";
        } else if ((action.equals("pierre") && computerAction.equals("ciseaux"))
                || (action.equals("feuille") && computerAction.equals("pierre"))
                || (action.equals("ciseaux") && computerAction.equals("feuille"))) {
            result = "gagné";
            gameScore.setWins(gameScore.getWins() + 1);
        } else {
            result = "perdu";
            gameScore.setLosses(gameScore.getLosses() + 1);
        }
        return "Vous avez joué " + action + ", l'ordinateur a joué " + computerAction + ", vous avez " + result;
    }


    @PostMapping("/game/restart")
    public void restartGame() {
        gameScore.setWins(0);
        gameScore.setLosses(0);
        gameScore.setTies(0);
    }


    @GetMapping("/game/score")
    public GameScore getScore() {
        return gameScore;
    }


    @PutMapping("/game/score/{win}/{loose}/{tie}")
    public void updateScore(@PathVariable int win, @PathVariable int loose, @PathVariable int tie) {
        gameScore.setWins(win);
        gameScore.setLosses(loose);
        gameScore.setTies(tie);
    }
}
