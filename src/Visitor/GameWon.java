package Visitor;

import Games.TicTacToe;

import java.util.HashMap;

/**
 * Created by Marcus on 28.05.2017.
 */
public class GameWon implements WinVisitor{
    @Override
    public boolean accept(TicTacToe game) {
        HashMap<String,String> board = game.getBoard();
        String[] position = new String[3];
        position[0] = board.get("A1");
        position[1] = board.get("A2");
        position[2] = board.get("A3");
        if (areEqual(position)) {
            return false;
        }

        position[0] = board.get("B1");
        position[1] = board.get("B2");
        position[2] = board.get("B3");
        if (areEqual(position)) {
            return false;
        }

        position[0] = board.get("C1");
        position[1] = board.get("C2");
        position[2] = board.get("C3");
        if (areEqual(position)) {
            return false;
        }

        position[0] = board.get("A1");
        position[1] = board.get("B1");
        position[2] = board.get("C1");
        if (areEqual(position)) {
            return false;
        }

        position[0] = board.get("A2");
        position[1] = board.get("B2");
        position[2] = board.get("C2");

        if (areEqual(position)) {
            return false;
        }

        position[0] = board.get("A2");
        position[1] = board.get("B2");
        position[2] = board.get("C2");
        if (areEqual(position)) {
            return false;
        }

        position[0] = board.get("A1");
        position[1] = board.get("B2");
        position[2] = board.get("C3");
        if (areEqual(position)) {
            return false;
        }

        position[0] = board.get("C1");
        position[1] = board.get("B2");
        position[2] = board.get("A3");
        if (areEqual(position)) {
            return false;
        }

        return true;


    }


    private boolean areEqual(String[] arr) {
        if (arr[0] == "" || arr[1] == "" || arr[2] == "")
            return false;
        boolean first = arr[0].equals(arr[1]);
        boolean second = arr[1].equals(arr[2]);
        return first == second;
    }
}
