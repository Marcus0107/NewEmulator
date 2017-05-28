package Visitor;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Marcus on 28.05.2017.
 */
public interface Visitor {
    void accept(PrintVis vis);
    LinkedList<String> accept(LegalMovesVis vis);
    boolean accept(WinVisitor vis);
}
