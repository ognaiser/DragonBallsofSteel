package org.academia.dragonballsofsteel;

/**
 * Path to all of the skins to Goku
 */

public enum SkinTypeGoku {
    GokuStartRight("Resources/goku/goku_start_direita.png"),
    GokuStartLeft("Resources/goku/goku_start_esquerda.png"),
    GokuGroundLeft("Resources/goku/goku_ground_esquerda.png"),
    GokuGroundRight("Resources/goku/goku_ground_direita.png"),
    GokuDefLeft("Resources/goku/goku_defende_2_esquerda.png"),
    GokuDefRight("Resources/goku/goku_defende_2_direita.png"),
    GokuFlyLeft("Resources/goku/goku_voar_tras_esquerda.png"),
    GokuFlyRight("Resources/goku/goku_voar_tras_direita.png"),
    GokuPunchLeft("Resources/goku/goku_murro_2_esquerda.png"),
    GokuPunchRight("Resources/goku/goku_murro_2_direita.png"),
    GokuFallRight("Resources/goku/goku_cai_1_direita.png"),
    GokuFallLeft("Resources/goku/goku_cai_1_esquerda.png"),
    GokuDeadRigh("Resources/goku/goku_cai_3_direita.png"),
    GokuDeadLeft("Resources/goku/goku_cai_3_esquerda.png"),
    GokuHitLeft("Resources/goku/goku_cai_2_direita.png"),
    GokuHitRight("Resources/goku/goku_cai_2_esquerda.png"),
    GokuKickRight("Resources/goku/goku_pontape_2_direita.png"),
    GokuKickLeft("Resources/goku/goku_pontape_2_esquerda.png"),
    GokuCharge("Resources/goku/goku_charge.png"),
    GokuKamehamehaRigh("Resources/goku/goku_kame_right.png"),
    GokuKamehamehaLeft("Resources/goku/goku_kame_left.png");


    private String path;

    SkinTypeGoku(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
