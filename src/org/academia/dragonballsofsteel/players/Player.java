package org.academia.dragonballsofsteel.players;

import org.academia.dragonballsofsteel.PlayerHandlers;

/**
 * Game object to be inicializied by the game
 * Class that represents each player
 */

public class Player {

    private int health = 1000;
    private int energy = 100;
    private int punchPower = 20;
    private int kickPower = 20;
    private boolean defeated;
    private int posx;
    private int posy;
    private PlayerHandlers handler;

    public Player(int posx, int posy, PlayerHandlers handler) {
        this.posx = posx;
        this.posy = posy;
        //TODO: inicialize handler here!
    }

    public int getHealth(){
        return health;
    }

    public int getEnergy(){
        return energy;
    }

    public void takingDamage(int damage){
        if(health - damage < 0){
            health = 0;
            defeated = true;
            return;
        }
        health = health - damage;
    }

    public int punch(){
        return punchPower;
    }

    public int kick(){
        return kickPower;
    }

    public int energyAttack(){
        if(energy > 100){
            energy = energy - 100;
            return 100;
        }
        return -1;
    }

    public void burstOfEnergy(){
        energy += 2;
        if(energy > 150){
            punchPower = 30;
            kickPower = 30;
        }
        else{
            punchPower = 20;
            kickPower = 20;
        }
    }

    public boolean isDefeated(){
        return defeated;
    }
}
