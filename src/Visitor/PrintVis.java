package Visitor;

import Games.TicTacToe;

/**
 * Created by Marcus on 28.05.2017.
 */
public interface PrintVis {
    void accept(TicTacToe game);
}
