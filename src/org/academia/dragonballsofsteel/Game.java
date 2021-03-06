package org.academia.dragonballsofsteel;

import org.academia.dragonballsofsteel.players.Player;
import org.academia.dragonballsofsteel.players.PlayerColissionChecker;
import org.academia.dragonballsofsteel.players.PlayerType;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Game Logic
 */

public class Game {

    //TODO: get a health Display
    /**
     * Sets the Canvas limits
     */
    public static final int bottomBounderi = 581;
    public static final int rightBounderi = 1118;
    public static final int topBonderi = 146;
    public static final int leftBonderi = 143;
    protected static boolean foward = false;
    protected boolean isGameOver = false;
    private Picture back = new Picture(0, 0, SkinTypeExtra.Back.getPath());
    private Text gokuHealth;
    private Text vegetaHealth;
    private Text gokeEnergy;
    private Text vegetaEnergey;
    private Player player1;
    private Player player;


    /**
     * Loads the background and the instructions menu. When Space key is pressed starts the game
     * @throws InterruptedException
     */
    public void init() throws InterruptedException {

        //BackGround
        back.draw();

        int i = 0;
        MainScreenKeboardHandler handler = new MainScreenKeboardHandler();
        Picture instructionScreen = new Picture(0, 0, SkinTypeExtra.Start_Screen.getPath());
        instructionScreen.draw();

        while (!foward) {

            if (i == 0) {
                instructionScreen.load(SkinTypeExtra.Start_Screen.getPath());
                instructionScreen.draw();
                i++;
            } else {
                instructionScreen.load(SkinTypeExtra.Start_Screen_2.getPath());
                instructionScreen.draw();
                i--;
            }

            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
            }
        }

        handler.removeListners();
        instructionScreen.delete();

        //Game Start
        start();
    }

    /**
     * initializes the Players, the Collision checker and runs the game until one player loses
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {
        //Player1
        player = new Player(PlayerType.PLAYERONE);

        //Player2
        player1 = new Player(PlayerType.PLAYERTWO);

        //Colision Cheker
        PlayerColissionChecker checker = new PlayerColissionChecker(player, player1);
        player.setColisionChecker(checker);
        player1.setColisionChecker(checker);

        gokuHealth = new Text(900,100,"Goku Health: " + player1.getHealth());
        vegetaHealth = new Text(200,100,"Vegeta Health: " + player.getHealth());
        gokeEnergy = new Text(900,140,"Goku Energy: " + player1.getEnergy());
        vegetaEnergey = new Text(200, 140,"Vegeta Energy: " + player.getEnergy());
        gokuHealth.grow(10,10);
        vegetaHealth.grow(10,10);
        gokeEnergy.grow(10,10);
        vegetaEnergey.grow(10,10);
        gokuHealth.draw();
        vegetaHealth.draw();
        vegetaEnergey.draw();
        gokeEnergy.draw();


         //The game runs until one player loses is health
        while (!isGameOver) {

            //Player 1 punch if the Player 2 dont blocks
            if (player.getKey().getKey() == KeyboardEvent.KEY_Q && player.isKeyPressed()) {

                if (checker.fightingRange() && (player1.getKey().getKey() != KeyboardEvent.KEY_L)) {

                    if ((player.getPosx() > player1.getPosx() && player.facingRight()) ||
                            (player.getPosx() < player1.getPosx() && !player.facingRight())) {

                        player1.moveInDirection(player.getPosx(), player1.takingDamage(player.punch()));
                        player1.setSideSkin(player1.facingRight());
                        System.out.println("Goku : " + player1.getHealth());
                        player.setKeyPressed();
                    }
                }
            }

            //Player 1 blocking damage
            if (player.getKey().getKey() == KeyboardEvent.KEY_E && player.isKeyPressed()) {
                player.blockAttack(checker.fightingRange());
                player.setKeyPressed();
            }

            //Player 1 kick if Player 2 dont blocks
            if (player.getKey().getKey() == KeyboardEvent.KEY_X && player.isKeyPressed()) {

                if (checker.fightingRange() && (player1.getKey().getKey() != KeyboardEvent.KEY_L)) {

                    if ((player.getPosx() > player1.getPosx() && player.facingRight()) ||
                            (player.getPosx() < player1.getPosx() && !player.facingRight())) {

                        player1.moveInDirection(player.getPosx(), player1.takingDamage(player.kick()));
                        player1.setSideSkin(player1.facingRight());
                        System.out.println("Goku : " + player1.getHealth());
                        player.setKeyPressed();
                    }
                }
            }

            //Player 1 recharging energy
            if (player.getKey().getKey() == KeyboardEvent.KEY_F && player.isKeyPressed()) {
                player.burstOfEnergy();
                player.setKeyPressed();
            }

            //Player 1 teleports to Player 2
            if (player.getKey().getKey() == KeyboardEvent.KEY_A && player.getPreviousKey().getKey() == KeyboardEvent.KEY_F &&
                    player.isKeyPressed()) {
                if (player.teleport() && player.getPosx() < player1.getPosx()) {
                    if (player1.getPosx() + player1.getWidth() + 5 + player.getWidth() <= rightBounderi) {
                        player.setPos(player1.getPosx() + player1.getWidth() + 5, player1.getPosy(), player1.facingRight());
                    }
                }
                if (player.teleport() && player.getPosx() > player1.getPosx()) {
                    if (player1.getPosx() - 5 - player.getWidth() >= leftBonderi) {
                        player.setPos(player1.getPosx() - player.getWidth() - 5, player1.getPosy(), player1.facingRight());
                    }
                }
                player.setKeyPressed();
            }

            //Player 1 teleports to Player 2 if moving up below Player 2
            if (player.getKey().getKey() == KeyboardEvent.KEY_W && player.isKeyPressed() && (player.getPosy() - player1.getPosy() - player1.getHeight() <= 10) && Math.abs(player.getPosx() - player1.getPosx()) < 20) {
                if (player1.facingRight()) {
                    player.setPos(player1.getPosx() - player.getWidth() - 5, player1.getPosy(), player1.facingRight());
                } else {
                    player.setPos(player1.getPosx() + player1.getWidth() + 5, player1.getPosy(), player1.facingRight());
                }
            }

            //Player 1 does combo attack pushing Player 2 and teleports
            if (player.getKey().getKey() == KeyboardEvent.KEY_Q && player.isKeyPressed() && player.getPreviousKey().getKey() == KeyboardEvent.KEY_X && player.getEnergy() > 100) {
                System.out.println(player.getEnergy());
                if (player1.getPosx() + player1.getWidth() + 5 + player.getWidth() <= rightBounderi) {
                    player1.moveInDirection(player.getPosx(), player1.takingDamage(player.attackCombo()));
                    player.setPos(player1.getPosx() + player1.getWidth() + 5, player1.getPosy(), player1.facingRight());
                }
                if (player1.getPosx() - 5 - player.getWidth() >= leftBonderi) {
                    player1.moveInDirection(player.getPosx(), player1.takingDamage(player.attackCombo()));
                    player.setPos(player1.getPosx() - player.getWidth() - 5, player1.getPosy(), player1.facingRight());
                }
                player.setKeyPressed();
            }

            //Player 2 punch if Player 1 dont blocks
            if (player1.getKey().getKey() == KeyboardEvent.KEY_K && player1.isKeyPressed()) {
                if (checker.fightingRange() && (player.getKey().getKey() != KeyboardEvent.KEY_E)) {

                    if ((player1.getPosx() > player.getPosx() && player1.facingRight()) ||
                            (player1.getPosx() < player.getPosx() && !player1.facingRight())) {

                        player.moveInDirection(player1.getPosx(), player.takingDamage(player1.punch()));
                        player.setSideSkin(player.facingRight());
                        System.out.println("Vegeta : " + player.getHealth());
                        player1.setKeyPressed();
                    }
                }
            }

            //Player 2 kick if Player 1 dont blocks
            if (player1.getKey().getKey() == KeyboardEvent.KEY_P && player1.isKeyPressed()) {

                if (checker.fightingRange() && (player.getKey().getKey() != KeyboardEvent.KEY_E)) {

                    if ((player1.getPosx() > player.getPosx() && player1.facingRight()) ||
                            (player1.getPosx() < player.getPosx() && !player1.facingRight())) {

                        player.moveInDirection(player1.getPosx(), player.takingDamage(player1.kick()));
                        player.setSideSkin(player.facingRight());
                        System.out.println("Vegeta : " + player.getHealth());
                        player1.setKeyPressed();
                    }
                }
            }

            //Player 2 recharges energy
            if (player1.getKey().getKey() == KeyboardEvent.KEY_O && player1.isKeyPressed()) {
                player1.burstOfEnergy();
                player1.setKeyPressed();
            }

            //Player 2 blocks damage
            if (player1.getKey().getKey() == KeyboardEvent.KEY_L && player1.isKeyPressed()) {
                player1.blockAttack(checker.fightingRange());
                player1.setKeyPressed();
            }

            //Player 2 teleports to Player 1 position
            if (player1.getKey().getKey() == KeyboardEvent.KEY_O && player1.getPreviousKey().getKey() == KeyboardEvent.KEY_RIGHT) {
                if (player1.teleport() && player1.getPosx() < player.getPosx()) {
                    if (player.getPosx() + player.getWidth() + 5 + player1.getWidth() <= rightBounderi) {
                        player1.setPos(player.getPosx() + player.getWidth() + 5, player.getPosy(), player.facingRight());
                    }
                }
                if (player1.teleport() && player1.getPosx() > player.getPosx()) {
                    if (player.getPosx() - 5 - player1.getWidth() >= leftBonderi) {
                        player1.setPos(player.getPosx() - player1.getWidth() - 5, player.getPosy(), player.facingRight());
                    }
                }
                player1.setKeyPressed();
            }

            //Player 2 teleports to Player 1 if moving up below Player 1
            if (player1.getKey().getKey() == KeyboardEvent.KEY_UP && player1.isKeyPressed() && (player1.getPosy() - player.getPosy() - player.getHeight() <= 10) && Math.abs(player1.getPosx() - player.getPosx()) < 20) {
                if (player.facingRight()) {
                    player1.setPos(player.getPosx() - player1.getWidth() - 5, player.getPosy(), true);
                } else {
                    player1.setPos(player.getPosx() + player.getWidth() + 5, player.getPosy(), false);
                }
            }

            //Player 2 does attack combo pushing Player 1 and teleports
            if (player1.getKey().getKey() == KeyboardEvent.KEY_K && player1.isKeyPressed() && player1.getPreviousKey().getKey() == KeyboardEvent.KEY_P && player1.getEnergy() > 100) {
                if (player.getPosx() + player.getWidth() + 5 + player1.getWidth() <= rightBounderi) {
                    player.moveInDirection(player1.getPosx(), player.takingDamage(player1.attackCombo()));
                    player1.setPos(player.getPosx() + player.getWidth() + 5, player.getPosy(), player.facingRight());
                }
                if (player.getPosx() - 5 - player1.getWidth() >= leftBonderi) {
                    player.moveInDirection(player1.getPosx(), player.takingDamage(player1.attackCombo()));
                    player1.setPos(player.getPosx() - player1.getWidth() - 5, player.getPosy(), player.facingRight());
                }
                player1.setKeyPressed();
            }

            //Increases speed of Player 1 when energy increases
            if (player.getEnergy() > 120) {
                player.setSpeed(player.getEnergy() / 10);
            } else {
                player.setSpeed(0);
            }

            //Increases speed of Player 2 when energy increases
            if (player1.getEnergy() > 120) {
                player1.setSpeed(player1.getEnergy() / 10);
            } else {
                player1.setSpeed(0);
            }

            //End Game condition
            if (player.isDefeated() || player1.isDefeated()) {

                isGameOver = true;

                gokuHealth.delete();
                vegetaHealth.delete();
                gokeEnergy.delete();
                vegetaEnergey.delete();

                foward = false;

                MainScreenKeboardHandler handler = new MainScreenKeboardHandler();
                Picture victory;

                if (player.isDefeated()) {
                    Picture vegeta = new Picture(player1.getPosx(), player1.getPosy(), SkinTypeVegeta.VegetaDeadLeft.getPath());
                    player.setSkin(vegeta, player1.getPosy());

                    Thread.sleep(800);

                    vegeta.delete();
                    player.clean();
                    player1.clean();
                    victory = new Picture(0, 0, SkinTypeExtra.Goku_Wins.getPath());
                    victory.draw();
                } else {
                    Picture goku = new Picture(player.getPosx(), player.getPosy(), SkinTypeGoku.GokuDeadRigh.getPath());
                    player1.setSkin(goku, player.getPosy());

                    Thread.sleep(800);

                    goku.delete();
                    player.clean();
                    player1.clean();
                    victory = new Picture(0, 0, SkinTypeExtra.Vegeta_Wins.getPath());
                    victory.draw();
                }

                while (!foward) {

                    Thread.sleep(800);

                }

                victory.delete();

                handler.removeListners();

            }

            updateUI();


            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }

        }


        back.delete();
    }

    private void updateUI() {
        gokuHealth.setText("Goku Health: " + player1.getHealth());
        vegetaHealth.setText("Vegeta Health: " + player.getHealth());
        vegetaEnergey.setText("Vegeta Energy: "+ player.getEnergy());
        gokeEnergy.setText("Goku Energy: "+ player1.getEnergy());
    }

}
