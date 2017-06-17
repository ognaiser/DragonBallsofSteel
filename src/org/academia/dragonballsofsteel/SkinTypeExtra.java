package org.academia.dragonballsofsteel;

public enum SkinTypeExtra {
    Back("Resources/DB_Screens/Background_DB.jpg"),
    BackCity("Resources/DB_Screens/backcity.png"),
    Start_Screen("Resources/DB_Screens/DB_StartScreen_1.png"),
    Start_Screen_2("Resources/DB_Screens/DB_StartScreen_2.png"),
    Vegeta_Wins("Resources/DB_Screens/DB_Vegeta_Wins_Screen.png"),
    Goku_Wins("Resources/DB_Screens/DB_Goku_Wins_Screen.png");

    private String path;

    SkinTypeExtra(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
