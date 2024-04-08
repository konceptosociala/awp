package org.verstiukhnutov.swelm.utils;

public class Color extends java.awt.Color {
    public static final Color GRAY = new Color(57, 57, 57);
    public static final Color LIGHT_GRAY = new Color(71, 71, 71);
    public static final Color BLUE = new Color(46, 138, 247);


    public Color(int r, int g, int b) {
        super(r, g, b);
    }

    public String toHex() {
        return String.format("#%02x%02x%02x", getRed(), getGreen(), getBlue());
    }
}
