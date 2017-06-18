package org.academia.sniper;

public enum WindowPos {
    WINDOW_LEFT_1(296, 153),
    WINDOW_LEFT_2(188, 220),
    WINDOW_LEFT_3(240, 290),
    WINDOW_LEFT_4(358, 359),
    WINDOW_LEFT_5(295, 433),
    WINDOW_MIDDLE_1(545, 200),
    WINDOW_MIDDLE_2(650, 260),
    WINDOW_MIDDLE_3(547, 320),
    WINDOW_MIDDLE_4(500, 380),
    WINDOW_MIDDLE_5(650, 441),
    WINDOW_RIGHT_1(1022, 320);

    private int X;
    private int Y;

    WindowPos(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
}
