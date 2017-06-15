package org.academia.dragonballsofsteel;

/**
 * Path to all of the skins
 */

public enum SkinTypeVegeta {
    VegetaStartRight("Resources/vegeta/vegeta_start_direita.png"),
    VegetaStartLeft("Resources/vegeta/vegeta_start_esquerda.png"),
    VegetaGroundLeft("Resources/vegeta/vegeta_start_2_esquerda.png"),
    VegetaGroundRight("Resources/vegeta/vegeta_start_2_direita.png"),
    VegetaDefLeft("Resources/vegeta/vegeta_defesa_esquerda.png"),
    VegetaDefRight("Resources/vegeta/vegeta_defesa_direita.png"),
    VegetaFlyLeft("Resources/vegeta/vegeta_voar_esquerda.png"),
    VegetaFlyRight("Resources/vegeta/vegeta_voar_direta.png"),
    VegetaPunchLeft("Resources/vegeta/vegeta_murro_2_esquerda.png"),
    VegetaPunchRight("Resources/vegeta/vegeta_murro_2_direita.png"),
    VegetaFallRight("Resources/vegeta/vegeta_cai_2_direita.png"),
    VegeteFallLeft("Resources/vegeta/vegeta_cai_2_esquerda.png"),
    VegetaDeadRigh("Resources/vegeta/vegeta_cai_3_direita.png"),
    VegetaDeadLeft("Resources/vegeta/vegeta_cai_3_esquerda.png");


    private String path;

    SkinTypeVegeta(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
