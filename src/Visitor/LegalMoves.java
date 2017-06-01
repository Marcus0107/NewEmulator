package Visitor;

import Games.TicTacToe;
import Visitor.Interfaces.LegalMovesVis;

import java.util.LinkedList;

/**
 * Created by Marcus on 28.05.2017.
 */
public class LegalMoves implements LegalMovesVis
{
    @Override
    public LinkedList<String> accept(TicTacToe game) {
        LinkedList<String> legalMoves = new LinkedList<>();
        String[] vertical = {"A", "B", "C"};
        String[] horizontal = {"1", "2", "3"};
        int length = horizontal.length;
        for (int i = 0; i < length; i++) {
            for (int y = 0; y < length; y++) {
                String point = vertical[i] + horizontal[y];
                if (game.getBoard().get(point) == "") {
                    legalMoves.add(point);
                }
            }
        }
        return legalMoves;
    }
}
