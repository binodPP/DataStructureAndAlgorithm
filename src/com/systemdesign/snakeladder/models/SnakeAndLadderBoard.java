package com.systemdesign.snakeladder.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeAndLadderBoard {
    private int size;
    private List<Snake> snakes;
    private List<Ladder> ladders;
    private Map<String , Integer> playersPosition;

    public SnakeAndLadderBoard(int size) {
        this.size = size;
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();
        this.playersPosition = new HashMap<>();
    }

    public int getSize() {
        return size;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public Map<String, Integer> getPlayersPosition() {
        return playersPosition;
    }

    public void setPlayersPosition(Map<String, Integer> playersPosition) {
        this.playersPosition = playersPosition;
    }
}
