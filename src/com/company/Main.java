package com.company;

import Games.TicTacToe;
import Strategy.EasyPlayerTwo;
import Strategy.HumanPlayerTwo;
import Visitor.Printer;

import java.io.IOException;
import java.util.Date;

public class Main
{

    public static void main(String[] args) throws IOException
    {

        TicTacToeBuilder builder = new TicTacToeBuilder();
        builder.setOne(new Player("Marcus", "Marcus@Test.de", "Tic Tac Toe Master", new Date(2017, 1, 1)));

        builder.setStrategy(new HumanPlayerTwo());
        builder.addListeners((game1, move) ->
        {
            game1.addMove(move);
            System.out.println("Pop up - your opponent moved");

        });

        if (builder.getStrategy() instanceof HumanPlayerTwo)
        {
            builder.setTwo(new Player("Patric", "Patrick@Test.de", "Tic Tac Toe Newbie", new Date(2017, 5, 5)));
        }else{
            builder.setTwo(null);
        }


        TicTacToe game = builder.build();

        game.accept(new Printer());

        boolean isRunning = true;
        int counter = 2;

        while (isRunning)
        {
            if (counter % 2 == 0)
            {
                isRunning = game.doMove(game.readMove());
            }
            else
            {
                isRunning = game.simulatePlayerTwo();
            }
            counter++;
        }
    }
}
