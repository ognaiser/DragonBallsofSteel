package org.academia.noughtsandcrosses;

/**
 * Created by codecadet on 19/06/17.
 */
public enum skins {
    kardashian("Resources/kardashian_face.png"),
    been("Resources/been_face.png");

    private String path;

    skins(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
