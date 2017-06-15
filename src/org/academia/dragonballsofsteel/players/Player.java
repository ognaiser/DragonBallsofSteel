package org.academia.dragonballsofsteel.players;

import org.academia.dragonballsofsteel.PlayerHandlers;

/**
 * Game object to be inicializied by the game
 * Class that represents each player
 */

public class Player {

    protected int posx;
    protected int posy;
    private PlayerHandlers handler;

    public Player(int posx, int posy, PlayerHandlers handler) {
        this.posx = posx;
        this.posy = posy;
        //TODO: inicialize handler here!
    }


}
