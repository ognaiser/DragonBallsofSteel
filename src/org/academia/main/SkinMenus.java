package org.academia.main;

public enum SkinMenus {
    ArcadeMenu("Resources/Arcade_Menu.png"),
    DragonBalls("Resources/DB_Screens/dragon_ball_menu.png"),
    SnipeMenu("Resources/sniper_elite_menu.jpg"),
    hacking_1("Resources/hacking_1.jpg"),
    hacking_2("Resources/hacking_2.jpg"),
    hacking_3("Resources/hacking_3.jpg"),
    hacking_4("Resources/hacking_4.jpg"),
    hacking_5("Resources/hacking_5.jpg"),
    hacking_end("Resources/hacking_end.jpg");



    private String path;

    SkinMenus(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
