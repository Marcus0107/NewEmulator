package Visitor;

import Games.TicTacToe;
import Visitor.Interfaces.PrintVis;

/**
 * Created by Marcus on 28.05.2017.
 */
public class Printer implements PrintVis
{
    @Override
    public void accept(TicTacToe game) {
        String output = "";
        String[] vertical = {"A", "B", "C"};
        String[] horizontal = {"1", "2", "3"};
        int length = horizontal.length;
        output += "\t-\t\t-\t\t-\n";
        for (int i = 0; i < length; i++) {
            output += vertical[i] + "|";
            for (int y = 0; y < length; y++) {
                output += "\t" + game.getBoard().get(vertical[i] + horizontal[y]) + "\t|";
                //System.out.println(vertical[i] + horizontal[y]);
            }
            output += "\n";
            output += "\t-\t\t-\t\t-\n";
        }
        output += "\t1\t\t2\t\t3\n";
        System.out.println(output);
    }
}
