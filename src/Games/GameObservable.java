package Games;

import Observer.MoveListener;
import Strategy.ComputePlayerTwo;
import Visitor.Visitor;
import com.company.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Marcus on 26.05.2017.
 */
public abstract class GameObservable implements Visitor
{
    final LinkedList<String> moves;
    final ComputePlayerTwo strategy;
    final ArrayList<MoveListener> listeners;
    final Player one;
    final Player two;

    public GameObservable(ComputePlayerTwo strategy, Player one, Player two)
    {
        this.one = one;
        this.two = two;
        moves = new LinkedList<>();
        this.strategy = strategy;
        listeners = new ArrayList<MoveListener>();
    }

    public ArrayList<MoveListener> getListeners()
    {
        return listeners;
    }

    public LinkedList<String> getMoves()
    {
        return moves;
    }

    public void addMove(String move)
    {
        moves.add(move);
    }

    public boolean simulatePlayerTwo() throws IOException
    {
        return strategy.simulatePlayerTwo(this);
    }

    public abstract boolean doMove(String move) throws IOException;
}
