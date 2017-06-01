package Visitor.Interfaces;

import Games.TicTacToe;

import java.util.LinkedList;

/**
 * Created by Marcus on 28.05.2017.
 */
public interface LegalMovesVis {

    LinkedList<String> accept(TicTacToe game);
}
