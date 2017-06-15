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
    private PlayerOneHandler handler;

    /**
     *
     * @param posx set position on X Axis
     * @param posy set position on Y Axis
     * @param handler defines which keyboard to use
     */
    public Player() {
        //TODO: inicialize handler here!
        handler = new PlayerOneHandler(10, this);
        this.posx = handler.getPosx();
        this.posy = handler.getPosy();
    }

    /**
     * Damage received by player
     * @param damage ill reduce players Health
     */
    public void takingDamage(int damage){
        if(health - damage < 0){
            health = 0;
            defeated = true;
            return;
        }
        health = health - damage;
    }

    /**
     * Attack Power of one punch
     * @return
     */
    public int punch(){
        return punchPower;
    }

    /**
     * Attack Power of one kick
     * @return
     */
    public int kick(){
        return kickPower;
    }

    /**
     * Checks if the Player has enough energy to attack.
     * @return damage of energy attack or -1 if he cant attack and it spawns different animation
     */
    public int energyAttack(){
        if(energy > 100){
            return energy -= 60;
        }
        return -1;
    }

    /**
     * Recharge energy. It will improve punch and kick power
     */
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

    /**
     * If the Player hits the enemy 3 consecutive times it does special combo
     * @return
     */
    public int attackCombo(){
        return punchPower + kickPower;
    }

    /**
     * Block incoming attacks at the cost of energy
     * @return
     */
    public int blockAttack(){
        if(energy < 10){
            return -1;
        }
        energy -= 2;
        return 0;
    }

    /**
     * Block and counterattack ate the cost of energy
     * @return
     */
    public int counterAttack(){
        if(energy < 10){
            return -1;
        }
        energy -= 5;
        return 0;
    }

    /**
     * Checks if the Player has been defetead
     * @return
     */
    public boolean isDefeated(){
        return defeated;
    }

    /**
     * Returns the Player Health
     * @return
     */
    public int getHealth(){
        return health;
    }

    /**
     * Return the Player Energy
     * @return
     */
    public int getEnergy(){
        return energy;
    }
}
