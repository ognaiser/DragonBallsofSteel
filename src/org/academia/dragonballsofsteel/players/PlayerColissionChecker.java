package org.academia.dragonballsofsteel.players;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

public class PlayerColissionChecker {

    //todo get a timer


    private Player playerOne;
    private Player playerTwo;

    public PlayerColissionChecker(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public int getPlayerOneX() {
        return playerOne.getPosx();
    }

    public int getPlayerOneY() {
        return playerOne.getPosy();
    }

    public int getPlayerTwoX() {
        return playerTwo.getPosx();
    }

    public int getPlayerTwoY() {
        return playerTwo.getPosy();
    }

    public boolean checkPlayerCollision(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_A:
                if (checkXLeftPlayerOne() && checkY()) {
                    return true;
                }
                break;
            case KeyboardEvent.KEY_D:
                if (checkXRightPlayerOne() && checkY()) {
                    return true;
                }
                break;
            case KeyboardEvent.KEY_LEFT:
                if (checkXLeft() && checkY()) {
                    return true;
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                if (checkXRight() && checkY()) {
                    return true;
                }
                break;
        }
        return false;
    }

    private boolean checkXRight(){
        if ((playerTwo.getPosx() + playerTwo.getWidth() - 10 + playerTwo.getSpeed()/2 >= playerOne.getPosx()) &&
                playerTwo.getPosx() + playerTwo.getWidth() - 10 + playerTwo.getSpeed()/2 <= playerOne.getPosx() + playerOne.getWidth() ) {
            return true;
        }
        return false;
    }

    private boolean checkXLeft(){
        if ((playerTwo.getPosx()  - playerTwo.getSpeed()/2 >= playerOne.getPosx()) && playerTwo.getPosx() - playerTwo.getSpeed()/2 <= playerOne.getPosx() + playerOne.getWidth() ) {
            return true;
        }
        return false;
    }

    private boolean checkXRightPlayerOne(){
        if ((playerOne.getPosx() + playerOne.getWidth() - 10 + playerOne.getSpeed()/2 >= playerTwo.getPosx()) &&
                playerOne.getPosx() + playerOne.getWidth() - 10 + playerOne.getSpeed()/2 <= playerTwo.getPosx() + playerTwo.getWidth() ) {
            return true;
        }
        return false;
    }

    private boolean checkXLeftPlayerOne(){
        if ((playerOne.getPosx()  - playerOne.getSpeed()/2 >= playerTwo.getPosx()) && playerOne.getPosx() - playerOne.getSpeed()/2 <= playerTwo.getPosx() + playerTwo.getWidth() ) {
            return true;
        }
        return false;
    }

    private boolean checkY() {
        if (playerOne.getPosy() >= playerTwo.getPosy() && playerOne.getPosy() <= playerTwo.getPosy() + playerTwo.getHeight()) {
            return true;
        }
        if ((playerOne.getPosy() + playerOne.getHeight() >= playerTwo.getPosy()) && playerOne.getPosy() + playerOne.getHeight() <= playerTwo.getPosy() + playerTwo.getHeight() ) {
            return true;
        }
        if (playerTwo.getPosy() >= playerOne.getPosy() && playerTwo.getPosy() <= playerOne.getPosy() + playerOne.getHeight()) {
            return true;
        }
        if ((playerTwo.getPosy() + playerTwo.getHeight() >= playerOne.getPosy()) && playerTwo.getPosy() + playerTwo.getHeight() <= playerOne.getPosy() + playerOne.getHeight() ) {
            return true;
        }
        return false;
    }

    public boolean fightingRange(){
        if(Math.abs(playerTwo.getPosx() - (playerOne.getPosx() + playerOne.getWidth())) <= 8  || Math.abs(playerOne.getPosx() - (playerTwo.getPosx() + playerTwo.getWidth())) <= 8){
            if(checkY()) {
                return true;
            }
        }

        return false;
    }
}

