package org.academia.dragonballsofsteel;

public enum  SkinTypeExtra {
    Back("Resources/back.png"),
    BackCity("Resources/backcity.png");

    private String path;

    SkinTypeExtra(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
