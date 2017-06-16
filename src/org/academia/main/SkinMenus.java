package org.academia.main;

public enum SkinMenus {
    ArcadeMenu("Resources/Arcade_Menu.png"),
    DragonBalls("Resources/dragon_ball_menu.png");


    private String path;

    SkinMenus(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
