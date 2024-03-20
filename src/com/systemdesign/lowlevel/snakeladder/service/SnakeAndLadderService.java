package com.systemdesign.lowlevel.snakeladder.service;

import com.systemdesign.lowlevel.snakeladder.models.Ladder;
import com.systemdesign.lowlevel.snakeladder.models.Player;
import com.systemdesign.lowlevel.snakeladder.models.Snake;
import com.systemdesign.lowlevel.snakeladder.models.SnakeAndLadderBoard;

import java.util.*;

public class SnakeAndLadderService {
    private static final int DEFAULT_BOARD_SIZE=100;
    private static final int DEFAULT_DICE_NO=1;
    private SnakeAndLadderBoard snakeAndLadderBoard;
    private int initialNoOfPlayer;
    private Queue<Player> players;
    private boolean isGameCompleted;


    private int noOfDices;//Optional-1
    private boolean shouldGameContinueTillLastPlayer;//Optional-3
    private boolean shouldAllowMultipleDiceRollOnSix;//Optional-4

    public SnakeAndLadderService(int boardSize) {
        this.snakeAndLadderBoard = new SnakeAndLadderBoard(boardSize); //Optional-2
        this.players = new LinkedList<>();
        this.noOfDices = DEFAULT_DICE_NO;
    }

    public SnakeAndLadderService() {
        this(DEFAULT_BOARD_SIZE);
    }

    //Initialize Board
    public void setNoOfDices(int noOfDices) {
        this.noOfDices = noOfDices;
    }

    public void setShouldGameContinueTillLastPlayer(boolean shouldGameContinueTillLastPlayer) {
        this.shouldGameContinueTillLastPlayer = shouldGameContinueTillLastPlayer;
    }

    public void setShouldAllowMultipleDiceRollOnSix(boolean shouldAllowMultipleDiceRollOnSix) {
        this.shouldAllowMultipleDiceRollOnSix = shouldAllowMultipleDiceRollOnSix;
    }

    public void setPlayers(List<Player> players) {
        this.players = new LinkedList<>();
        this.initialNoOfPlayer = players.size();
        Map<String, Integer> playerPosition = new HashMap<>();

        for ( Player player : players) {
            this.players.add(player);
            playerPosition.put(player.getId(),0);
        }
        snakeAndLadderBoard.setPlayersPosition(playerPosition);
    }

    public void setSnakes(List<Snake> snakes) {
        snakeAndLadderBoard.setSnakes(snakes);
    }

    public void setLadder(List<Ladder> ladders) {
        snakeAndLadderBoard.setLadders(ladders);
    }


    //Business Logic***************************//

    public void startGame(){
        if(!isGameCompleted()){
            int totalDiceValue = getTotalValueAfterDiceRoll();
            Player currentPlayer = players.poll();
            movePlayers(currentPlayer, totalDiceValue);
            if(hasPlayerWonTheGame(currentPlayer)){
                snakeAndLadderBoard.getPlayersPosition().remove(currentPlayer.getId());
            }else {
               players.add(currentPlayer);
            }
        }
    }

    private boolean isGameCompleted(){
        int currentNoOfPlayer = players.size();
        return currentNoOfPlayer < initialNoOfPlayer;
    }

    private int getTotalValueAfterDiceRoll(){
        return DiceService.roll();
    }

    private void movePlayers(Player player, int position){
        int oldPosit = snakeAndLadderBoard.getPlayersPosition().get(player);
        int newPosit = oldPosit + position;

        int boardSize = snakeAndLadderBoard.getSize();

        if(newPosit < boardSize){
            newPosit = getNewPositionWhenUseSnakeAndLadder(newPosit);
        }else {
            newPosit = oldPosit;
        }

        snakeAndLadderBoard.getPlayersPosition().put(player.getId(),newPosit);
    }

    private boolean hasPlayerWonTheGame(Player player){
        int playerPosition = snakeAndLadderBoard.getPlayersPosition().get(player);
        int winPosition = snakeAndLadderBoard.getSize();
        return playerPosition == winPosition;
    }

    private int getNewPositionWhenUseSnakeAndLadder(int newPosition){
        int prevPosit=0;
        while(prevPosit != newPosition){
            prevPosit = newPosition;

            for (Snake snake : snakeAndLadderBoard.getSnakes()){
                if(snake.getStartPosition() == newPosition){
                    newPosition = snake.getEndPosition();
                }
            }

            for (Ladder ladder : snakeAndLadderBoard.getLadders()){
                if(ladder.getStartPosition() == newPosition){
                    newPosition = ladder.getEndPosition();
                }
            }
        }
        return newPosition;
    }

}
