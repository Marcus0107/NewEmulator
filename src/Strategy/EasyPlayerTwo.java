package Strategy;

import Games.GameObservable;
import Games.TicTacToe;
import Visitor.LegalMoves;

import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Marcus on 26.05.2017.
 */
public class EasyPlayerTwo implements ComputePlayerTwo {

    @Override
    public boolean simulatePlayerTwo(GameObservable game) throws IOException {
        LinkedList<String> moves = game.accept(new LegalMoves());
        int movesCount = moves.size();

        int randomNum = ThreadLocalRandom.current().nextInt(0, movesCount );

        return game.doMove(moves.get(randomNum) + " X");
    }
}
