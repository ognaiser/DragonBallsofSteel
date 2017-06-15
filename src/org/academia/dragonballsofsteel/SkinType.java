package org.academia.dragonballsofsteel;

/**
 * Path to all of the skins
 */

public enum SkinType {
    VegetaFrenteEsquerda("Resources/vegeta_frente_esquerda.png"),
    Back("Resources/back.png");

    private String path;

    SkinType(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
