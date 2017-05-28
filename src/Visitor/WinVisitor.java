package Visitor;

import Games.TicTacToe;

/**
 * Created by Marcus on 28.05.2017.
 */
public interface WinVisitor {
    boolean accept(TicTacToe game);
}
