package com.systemdesign.snakeladder;

import com.systemdesign.snakeladder.models.Ladder;
import com.systemdesign.snakeladder.models.Player;
import com.systemdesign.snakeladder.models.Snake;
import com.systemdesign.snakeladder.models.SnakeAndLadderBoard;
import com.systemdesign.snakeladder.service.SnakeAndLadderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter snakes");
        int noOfSnakes = scanner.nextInt();

        System.out.println("Enter snakes : " + noOfSnakes);
        List<Snake> snakes = new ArrayList<>();
        for (int i=0; i<noOfSnakes; i++){
            snakes.add(new Snake(scanner.nextInt(), scanner.nextInt()));
        }

        System.out.println("Enter ladders");
        int noOfLadders = scanner.nextInt();
        System.out.println("Enter ladders : " + noOfLadders);
        List<Ladder> ladders = new ArrayList<>();
        for (int i=0; i<noOfLadders; i++){
            ladders.add(new Ladder(scanner.nextInt(), scanner.nextInt()));
        }

        System.out.println("Enter players");
        int noOfPlayers = scanner.nextInt();
        System.out.println("Enter players : " + noOfPlayers);
        List<Player> players = new ArrayList<>();
        for (int i=0; i<noOfPlayers; i++){
            players.add(new Player(scanner.next()));
        }

        SnakeAndLadderService snakeAndLadderService = new SnakeAndLadderService();
        snakeAndLadderService.setSnakes(snakes);
        snakeAndLadderService.setLadder(ladders);
        snakeAndLadderService.setPlayers(players);

        snakeAndLadderService.startGame();
    }

}