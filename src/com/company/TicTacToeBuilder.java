package com.company;

import Games.GameObservable;
import Games.TicTacToe;
import Observer.MoveListener;
import Strategy.ComputePlayerTwo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Marcus on 28.05.2017.
 */
public class TicTacToeBuilder
{
    Player one;
    Player two;
    ComputePlayerTwo strategy;
    ArrayList<MoveListener> listeners;

    public TicTacToeBuilder()
    {
        listeners = new ArrayList<>();
    }

    public Player getOne()
    {
        return one;
    }

    public void setOne(Player one)
    {
        this.one = one;
    }

    public Player getTwo()
    {
        return two;
    }

    public void setTwo(Player two)
    {
        this.two = two;
    }

    public ComputePlayerTwo getStrategy()
    {
        return strategy;
    }

    public void setStrategy(ComputePlayerTwo strategy)
    {
        this.strategy = strategy;
    }

    public ArrayList<MoveListener> getListeners()
    {
        return listeners;
    }

    public void addListeners(MoveListener listener)
    {
        listeners.add(listener);
    }

    public TicTacToe build()
    {
        TicTacToe game = new TicTacToe(strategy, one, two);
        for (MoveListener listener : listeners)
        {
        game.addListener(listener);
        }
        return game;
    }
}
