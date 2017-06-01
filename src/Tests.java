import Games.TicTacToe;
import Strategy.HumanPlayerTwo;
import Visitor.LegalMoves;
import com.company.Player;
import com.company.TicTacToeBuilder;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Marcus on 28.05.2017.
 */
public class Tests
{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams()
    {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams()
    {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testBuilder()
    {
        TicTacToeBuilder builder = new TicTacToeBuilder();
        builder.setOne(new Player("Marcus", "Marcus@Test.de", "Tic Tac Toe Master", new Date(2017, 1, 1)));

        builder.setStrategy(new HumanPlayerTwo());
        builder.addListeners((game1, move) ->
        {
            game1.addMove(move);
            System.out.println("Pop up - your opponent moved");

        });

        TicTacToe game = builder.build();

        assertTrue(game.getStrategy() instanceof HumanPlayerTwo);
        assertEquals(game.getOne().getDisplayname(), "Tic Tac Toe Master");
    }

    @Test
    public void testObserver()
    {
        TicTacToeBuilder builder = new TicTacToeBuilder();
        builder.setOne(new Player("Marcus", "Marcus@Test.de", "Tic Tac Toe Master", new Date(2017, 1, 1)));

        builder.setStrategy(new HumanPlayerTwo());
        builder.addListeners((game1, move) ->
        {
            game1.addMove(move);
            System.out.println("Pop up - your opponent moved");

        });

        TicTacToe game = builder.build();
        game.doMove("A1 X");

        assertEquals(game.getBoard().get("A1"), "X");
        assertTrue(outContent.toString().contains("Pop up - your opponent moved"));
    }

    @Test
    public void gameWon()
    {
        TicTacToeBuilder builder = new TicTacToeBuilder();
        builder.setOne(new Player("Marcus", "Marcus@Test.de", "Tic Tac Toe Master", new Date(2017, 1, 1)));

        builder.setStrategy(new HumanPlayerTwo());
        builder.addListeners((game1, move) ->
        {
            game1.addMove(move);
            System.out.println("Pop up - your opponent moved");

        });

        TicTacToe game = builder.build();
        game.doMove("A1 X");
        game.doMove("B2 O");
        game.doMove("A2 X");
        game.doMove("B1 O");
        game.doMove("A3 X");
        assertTrue(outContent.toString().contains("Player one wins"));
    }

    @Test
    public void gameLost()
    {
        TicTacToeBuilder builder = new TicTacToeBuilder();
        builder.setOne(new Player("Marcus", "Marcus@Test.de", "Tic Tac Toe Master", new Date(2017, 1, 1)));

        builder.setStrategy(new HumanPlayerTwo());
        builder.addListeners((game1, move) ->
        {
            game1.addMove(move);
            System.out.println("Pop up - your opponent moved");

        });

        TicTacToe game = builder.build();
        game.doMove("A1 X");
        game.doMove("B2 O");
        game.doMove("A2 X");
        game.doMove("B1 O");
        game.doMove("C3 X");
        game.doMove("B3 O");
        assertTrue(outContent.toString().contains("Player two wins"));
    }

    @Test
    public void legalMovesLeft()
    {
        TicTacToeBuilder builder = new TicTacToeBuilder();
        builder.setOne(new Player("Marcus", "Marcus@Test.de", "Tic Tac Toe Master", new Date(2017, 1, 1)));

        builder.setStrategy(new HumanPlayerTwo());
        builder.addListeners((game1, move) ->
        {
            game1.addMove(move);
            System.out.println("Pop up - your opponent moved");

        });

        TicTacToe game = builder.build();

        List<String> legalMoves = game.accept(new LegalMoves());
        List<String> expectedMoves = new LinkedList<String>();
        expectedMoves.add("A1");
        expectedMoves.add("A2");
        expectedMoves.add("A3");
        expectedMoves.add("B1");
        expectedMoves.add("B2");
        expectedMoves.add("B3");
        expectedMoves.add("C1");
        expectedMoves.add("C2");
        expectedMoves.add("C3");
        Assert.assertEquals(expectedMoves, legalMoves);
    }



}