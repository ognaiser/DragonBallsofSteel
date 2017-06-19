package org.academia.dragonballsofsteel.players;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Game object to be inicializied by the game
 * Class that represents each player
 */

public class Player {

    private int health = 1000;
    private int energy = 100;
    private int punchPower = 20;
    private int kickPower = 20;
    private int hitCounter;
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
    public boolean takingDamage(int damage) {
        if(hitCounter > 2){
            hitCounter = 0;
            health = health - damage;
            return true;
        }
        if (health - damage < 0) {
            health = 0;
            defeated = true;
            return false;
        }
        health = health - damage;
        hitCounter++;
        return false;
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
        energy += 5;
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
        if (energy < 10) {
            return 0;
        }
        energy -= 10;

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

    /**
     * Set a collision checker to the Player
     * @param checker
     */
    public void setColisionChecker(PlayerColissionChecker checker){
        handler.setColisonCheker(checker);
    }

    /**
     *
     * @return the last key pressed
     */
    public KeyboardEvent getKey(){
        return handler.getLastKey();
    }

    /**
     *
     * @return the previous key pressed
     */
    public KeyboardEvent getPreviousKey() {
        return handler.getPreviousKey();
    }

    /**
     *
     * @return is the image is facing right
     */
    public boolean facingRight(){
        return handler.facingRight();
    }

    /**
     * moves the player image to the side of the second player image
     * @param direction
     */
    public void setSideSkin(boolean direction){
        handler.setSideSkin(direction);
    }

    /**
     * Places the image on a desired x and y and if is facing right
     * @param x
     * @param y
     * @param direction
     */
    public void setPos(int x, int y, boolean direction){
        handler.setPos(x, y, direction);
    }

    /**
     * Makes the player image sequentially move on X Axis and if is facing right
     * @param xPox
     * @param direction
     * @throws InterruptedException
     */
    public void moveInDirection(int xPox, boolean direction) throws InterruptedException {
        handler.moveInDirection(xPox, direction);
    }

    /**
     * Set a different amount of pixels that the image can move
     * @param amount
     */
    public void setSpeed(int amount){
        handler.setSpeed(amount);
    }

    /**
     * @return if a key is being pressed
     */
    public boolean isKeyPressed(){
        return handler.isKeyPressed();
    }

    /**
     * Key pressed changes to false
     */
    public void setKeyPressed(){
        handler.setKeyPressed();
    }

    /**
     * Make an image move on Y Axis to the Y max
     * @param pic
     * @param y
     * @throws InterruptedException
     */
    public void setSkin(Picture pic, int y) throws InterruptedException {
        handler.setSkin(pic, y);
    }

    /**
     * removes the handler keys and deletes the image
     */
    public void clean(){
        handler.clean();
    }

}
