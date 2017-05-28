package Observer;

import Games.GameObservable;

/**
 * Created by Marcus on 28.05.2017.
 */
public interface MoveListener
{
     void moveDone(GameObservable game, String move);
}
