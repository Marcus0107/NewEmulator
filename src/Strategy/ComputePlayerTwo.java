package Strategy;
import Games.GameObservable;

import java.io.IOException;

/**
 * Created by Marcus on 26.05.2017.
 */
public interface ComputePlayerTwo {
    boolean simulatePlayerTwo(GameObservable game) throws IOException;
}
