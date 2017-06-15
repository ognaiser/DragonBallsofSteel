package org.academia.dragonballsofsteel.players;

public class PlayerColissionChecker {

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
}

