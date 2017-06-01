package Visitor;

import Games.TicTacToe;
import Visitor.Interfaces.WinVisitor;

import java.util.HashMap;

/**
 * Created by Marcus on 28.05.2017.
 */
public class GameWon implements WinVisitor
{
    @Override
    public boolean accept(TicTacToe game)
    {
        HashMap<String, String> board = game.getBoard();
        String[] position = new String[3];

        String[] vertical = {"A", "B", "C"};
        String[] horizontal = {"1", "2", "3"};


        for (int i = 0; i < 3; i++)
        {
            for (int y = 0; y < 3; y++)
            {
                String letter = board.get(vertical[i] + horizontal[y]);
                if (letter != null)
                {
                    position[y] = letter;
                }
                else
                {
                    letter = "";
                    position[y] = letter;
                }
            }
            if (areEqual(position))
            {
                return true;
            }
        }

        for (int i = 0; i < 3; i++)
        {
            for (int y = 0; y < 3; y++)
            {
                String letter = board.get(vertical[y] + horizontal[i]);
                if (letter != null)
                {
                    position[y] = letter;
                }
                else
                {

                    position[y] = "";
                }
            }
            if (areEqual(position))
            {
                return true;
            }
        }

        position[0] = board.get("A1");
        position[1] = board.get("B2");
        position[2] = board.get("C3");
        if (areEqual(position))
        {
            return true;
        }

        position[0] = board.get("C1");
        position[1] = board.get("B2");
        position[2] = board.get("A3");
        if (areEqual(position))
        {
            return true;
        }
        return false;
    }


    private boolean areEqual(String[] arr)
    {
        if (arr[0] == "" || arr[1] == "" || arr[2] == "")
        {
            return false;
        }

        if (arr [0].equals(arr[1]) &&
                arr[1].equals(arr[2])&&
                arr[0].equals(arr[2])){
            return true;
        }else {
            return  false;
        }

    }
}
