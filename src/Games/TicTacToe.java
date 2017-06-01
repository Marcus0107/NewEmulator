package Games;

import Observer.MoveListener;
import Strategy.ComputePlayerTwo;
import Visitor.*;
import Visitor.Interfaces.LegalMovesVis;
import Visitor.Interfaces.PrintVis;
import Visitor.Interfaces.WinVisitor;
import com.company.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Marcus on 26.05.2017.
 */
public class TicTacToe extends GameObservable
{
    final HashMap<String, String> board;

    public TicTacToe(ComputePlayerTwo strategy, Player one, Player two)
    {
        super(strategy, one, two);
        board = new HashMap<>();
        initalizeBoard();
    }

    private void initalizeBoard()
    {
        String[] horizontal = {"A", "B", "C"};
        String[] vertical = {"1", "2", "3"};
        int length = horizontal.length;
        for (int i = 0; i < length; i++)
        {
            for (int y = 0; y < length; y++)
            {
                String point = horizontal[i] + vertical[y];
                board.put(point, "");
            }
        }
    }

    public String readMove() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    @Override
    public boolean doMove(String move)
    {
        for (MoveListener listener : getListeners())
        {
            listener.moveDone(this, move);
        }

        board.put(move.split(" ")[0], move.split(" ")[1]);

        boolean gameWon = new GameWon().accept(this);

        this.accept(new Printer());

        if (gameWon)
        {
            if (moves.size() % 2 == 1)
            {
                System.out.printf("Player one wins");
            }
            else
            {
                System.out.println("Player two wins");
            }
            return false;
        }
        else
        {
            return true;
        }
    }

    public HashMap<String, String> getBoard()
    {
        return board;
    }

    @Override
    public void accept(PrintVis visitor)
    {
        visitor.accept(this);
    }

    @Override
    public LinkedList<String> accept(LegalMovesVis vis)
    {
        return vis.accept(this);
    }

    @Override
    public boolean accept(WinVisitor vis)
    {
        return false;
    }



}
