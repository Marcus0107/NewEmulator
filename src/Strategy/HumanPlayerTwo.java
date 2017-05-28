package Strategy;

import Games.GameObservable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Marcus on 26.05.2017.
 */
public class HumanPlayerTwo implements ComputePlayerTwo {

    @Override
    public boolean simulatePlayerTwo(GameObservable game) throws IOException {
        System.out.println("Waiting for other player to do his move");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String move = br.readLine();
        boolean retValue = game.doMove(move);
        game.addMove(move);
        return retValue;
    }
}
