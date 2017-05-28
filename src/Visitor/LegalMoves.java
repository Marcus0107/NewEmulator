package Visitor;

import Games.TicTacToe;

import java.util.LinkedList;

/**
 * Created by Marcus on 28.05.2017.
 */
public class LegalMoves implements LegalMovesVis {
    @Override
    public LinkedList<String> accept(TicTacToe game) {
        LinkedList<String> legalMoves = new LinkedList<>();
        String[] vertical = {"A", "B", "C"};
        String[] horizontal = {"1", "2", "3"};
        for (int i = 0; i < horizontal.length; i++) {
            for (int y = 0; i < vertical.length; y++) {
                String point = vertical[i] + horizontal[y];
                if (game.getBoard().get(point) == "") {
                    legalMoves.add(point);
                }
            }
        }
        return legalMoves;
    }
}
