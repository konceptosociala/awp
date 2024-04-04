package org.verstiukhnutov.swelm.utils.border;

import org.verstiukhnutov.swelm.utils.Color;

public abstract class BorderFactory {
    
    public static Border empty() {
        return new Empty();
    }

    public static Border outline(Color color, int width) {
        return new Outline(color, width);
    }

    public static Border rounded(int radius) {
        return new Rounded(radius);
    }

}