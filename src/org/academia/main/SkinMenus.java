package org.academia.main;

public enum SkinMenus {
    ArcadeMenu("Resources/Arcade_Menu.png"),
    DragonBalls("Resources/DB_Screens/dragon_ball_menu.png"),
    SnipeMenu("Resources/sniper_elite_menu.jpg");



    private String path;

    SkinMenus(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
