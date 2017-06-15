package org.academia.dragonballsofsteel;

/**
 * Path to all of the skins
 */

public enum SkinType {
    VegetaFrente("Resources/vegeta_frente.png");

    private String path;

    SkinType(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
