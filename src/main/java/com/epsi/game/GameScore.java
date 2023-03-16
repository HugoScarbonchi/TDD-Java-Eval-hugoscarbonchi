package com.epsi.game;

import org.springframework.stereotype.Component;

@Component
public class GameScore {
    private int wins;
    private int losses;
    private int ties;

    public GameScore() {
        this.wins = 0;
        this.losses = 0;
        this.ties = 0;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    public void resetScore() {
        this.wins = 0;
        this.losses = 0;
        this.ties = 0;
    }
}
