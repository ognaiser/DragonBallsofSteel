package org.academia.dragonballsofsteel.players;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

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
    private PlayerHandler handler;

    /**
     *
     */
    public Player(PlayerType playerType) {

        if (playerType == PlayerType.PLAYERONE) {
            handler = new PlayerOneHandler(10, this);
        }else {
            handler = new PlayerTwoHandler(10,this);
        }

        this.posx = handler.getPosx();
        this.posy = handler.getPosy();
    }

    /**
     * Damage received by player
     *
     * @param damage ill reduce players Health
     */
    public void takingDamage(int damage) {
        if (health - damage < 0) {
            health = 0;
            defeated = true;
            return;
        }
        health = health - damage;
    }

    /**
     * Attack Power of one punch
     *
     * @return
     */
    public int punch() {
        return punchPower;
    }

    /**
     * Attack Power of one kick
     *
     * @return
     */
    public int kick() {
        return kickPower;
    }

    /**
     * Checks if the Player has enough energy to attack.
     *
     * @return damage of energy attack or -1 if he cant attack and it spawns different animation
     */
    public int energyAttack() {
        if (energy > 100) {
            return energy -= 60;
        }
        return -1;
    }

    /**
     * Recharge energy. It will improve punch and kick power
     */
    public void burstOfEnergy() {
        energy += 2;
        if (energy > 150) {
            punchPower = 30;
            kickPower = 30;
        } else {
            punchPower = 20;
            kickPower = 20;
        }
    }

    /**
     * If the Player hits the enemy 3 consecutive times it does special combo
     *
     * @return
     */
    public int attackCombo() {
        return punchPower + kickPower;
    }

    /**
     * Block incoming attacks at the cost of energy
     *
     * @return
     */
    public boolean blockAttack(boolean incomingAttack) {
        if(incomingAttack) {
            if (energy < 10) {
                return false;
            }
            energy -= 2;
            return true;
        }
        return true;
    }

    /**
     * Block and counterattack at the cost of energy
     *
     * @return
     */
    public int counterAttack() {
        if (energy < 10) {
            return -1;
        }
        energy -= 5;
        return 0;
    }

    public boolean teleport() {
        if(energy < 10){
            return false;
        }
        energy -= 10;
        return true;
    }

    /**
     * Checks if the Player has been defetead
     *
     * @return
     */
    public boolean isDefeated() {
        return defeated;
    }

    /**
     * Returns the Player Health
     *
     * @return
     */
    public int getHealth() {
        return health;
    }

    /**
     * Return the Player Energy
     *
     * @return
     */
    public int getEnergy() {
        return energy;
    }

    /**
     * Return position on X Axis
     *
     * @return
     */
    public int getPosx() {
        return handler.getPosx();
    }

    /**
     * Return position on Y Axis
     *
     * @return
     */
    public int getPosy() {
        return handler.getPosy();
    }

    /**
     * Return the width of the Player Picture
     *
     * @return
     */
    public int getWidth(){
        return handler.getWidth();
    }

    /**
     * Return the height of the Player Picture
     *
     * @return
     */
    public int getHeight(){
        return handler.getHeight();
    }

    /**
     * Return the amount of pixels the Picture can move
     *
     * @return
     */
    public int getSpeed(){
        return handler.getSpeed();
    }

    public void setColisionChecker(PlayerColissionChecker checker){
        handler.setColisonCheker(checker);
    }

    public KeyboardEvent getKey(){
        return handler.getLastKey();
    }

    public KeyboardEvent getPreviousKey() {
        return handler.getPreviousKey();
    }

    public boolean facingRight(){
        return handler.facingRight();
    }

    public void setSkin(boolean direction){
        handler.setSkin(direction);
    }

    public void setPos(int x, int y, boolean direction){
        handler.setPos(x, y, direction);
    }

    public boolean isKeyPressed(){
        return handler.isKeyPressed();
    }

    public void setKeyPressed(){
        handler.setKeyPressed();
    }

    public void clean(){
        handler.clean();
    }

}
