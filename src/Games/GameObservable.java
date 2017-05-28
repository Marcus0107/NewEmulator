package Games;

import Observer.Listener;
import Strategy.ComputePlayerTwo;
import Visitor.Visitor;
import com.company.Player;

import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by Marcus on 26.05.2017.
 */
public abstract class GameObservable implements Visitor {
    final LinkedList<String> moves;
    final ComputePlayerTwo strategy;
    Listener playerOne;
    Listener playerTwo;

    public Listener getPlayerOne() {
        return playerOne;
    }

    public Listener getPlayerTwo() {
        return playerTwo;
    }

    public GameObservable(ComputePlayerTwo strategy) {
        moves = new LinkedList<>();
        this.strategy = strategy;
    }

    public LinkedList<String> getMoves() {
        return moves;
    }

    public void addMove(String move) {
        moves.add(move);
    }

    public boolean simulatePlayerTwo() throws IOException {
        return strategy.simulatePlayerTwo(this);
    }

    public void addPlayOneListener(Listener listener) {
        playerOne = listener;
    }

public void addPlayerTwoListener(Listener listener){
    playerOne = listener;
}
    //public abstract LinkedList<String> legalMovesLeft();

    public abstract boolean doMove(String move) throws IOException;
}
