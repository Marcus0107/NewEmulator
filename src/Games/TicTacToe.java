package Games;

import Strategy.ComputePlayerTwo;
import Visitor.*;
import com.company.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Marcus on 26.05.2017.
 */
public class TicTacToe extends GameObservable {
    final HashMap<String, String> board;

    public TicTacToe(ComputePlayerTwo strategy) {

        super(strategy);
        board = new HashMap<>();
        initalizeBoard();
    }

/*
    public boolean hasLegalMoveLeft() {
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


    }*/

    private boolean areEqual(String[] arr) {
        if (arr[0] == "" || arr[1] == "" || arr[2] == "")
            return false;
        boolean first = arr[0].equals(arr[1]);
        boolean second = arr[1].equals(arr[2]);
        return first == second;
    }

    private void initalizeBoard() {
        String[] horizontal = {"A", "B", "C"};
        String[] vertical = {"1", "2", "3"};
        int length = horizontal.length;
        for (int i = 0; i < length; i++) {
            for (int y = 0; y < length; y++) {
                String point = horizontal[i] + vertical[y];
                board.put(point, "");
            }
        }
    }

    public String readMove() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    /*   @Override
       public String toString() {
           String output = "";
           String[] vertical = {"A", "B", "C"};
           String[] horizontal = {"1", "2", "3"};
           int length = horizontal.length;
           output += "\t-\t\t-\t\t-\n";
           for (int i = 0; i < length; i++) {
               output += vertical[i] + "|";
               for (int y = 0; y < length; y++) {
                   output += "\t" + board.get(vertical[i] + horizontal[y]) + "\t|";
                   //System.out.println(vertical[i] + horizontal[y]);
               }
               output += "\n";
               output += "\t-\t\t-\t\t-\n";
           }
           output += "\t1\t\t2\t\t3\n";
           return output;
       }
   /*
    @Override
    public LinkedList<String> legalMovesLeft() {
        LinkedList<String> legalMoves = new LinkedList<>();
        String[] vertical = {"A", "B", "C"};
        String[] horizontal = {"1", "2", "3"};
        for (int i = 0; i < horizontal.length; i++) {
            for (int y = 0; i < vertical.length; y++) {
                String point = vertical[i] + horizontal[y];
                if (board.get(point) == "") {
                    legalMoves.add(point);
                }
            }
        }
        return legalMoves;
    }*/

    @Override
    public boolean doMove(String move) {

        super.addMove(move);
        board.put(move.split(" ")[0], move.split(" ")[1]);
        boolean gameWon = new GameWon().accept(this);
        this.accept(new Printer());
        if (!gameWon) {
            System.out.printf("You win");
            return false;
        } else {
            return true;
        }
    }

    public HashMap<String, String> getBoard() {
        return board;
    }

    @Override
    public void accept(PrintVis visitor) {
        visitor.accept(this);
    }

    @Override
    public LinkedList<String> accept(LegalMovesVis vis) {
        return null;
    }

    @Override
    public boolean accept(WinVisitor vis) {
        return false;
    }
}
