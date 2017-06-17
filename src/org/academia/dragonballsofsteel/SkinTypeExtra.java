package org.academia.dragonballsofsteel;

public enum  SkinTypeExtra {
    Back("Resources/Background_DB.jpg"),
    BackCity("Resources/backcity.png");

    private String path;

    SkinTypeExtra(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
