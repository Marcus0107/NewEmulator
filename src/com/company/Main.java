package com.company;

import Games.TicTacToe;
import Observer.Listener;
import Strategy.HumanPlayerTwo;
import Visitor.Printer;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // cTacToe game = new TicTacToe(new HumanPlayerTwo(), new Player("Marcus","test@test.de","Displa Marcus",new Date(2017,1,1)),new Player("Marcus","test@test.de","Displa Marcus",new Date(2017,1,1)));
        TicTacToe game = new TicTacToe(new HumanPlayerTwo());
        boolean playerOneToMove = true;

        game.addPlayOneListener(new Listener() {
            @Override
            public boolean moveDone() {
                System.out.println("Pop Up Player one moved");
                return true;
            }

        });
        game.addPlayerTwoListener(new Listener() {
            @Override
            public boolean moveDone() {
                System.out.println("Player two moved");
              return false;
            }
        });
        game.accept(new Printer());

        boolean isRunning = true;
        while (isRunning) {
            if (playerOneToMove) {
                isRunning = game.doMove(game.readMove());
                game.getPlayerOne().moveDone();
            } else {
                isRunning = game.simulatePlayerTwo();
                game.getPlayerTwo().moveDone();
            }

        }


    }
}
