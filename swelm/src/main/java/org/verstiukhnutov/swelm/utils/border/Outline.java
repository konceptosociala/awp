package org.verstiukhnutov.swelm.utils.border;

import javax.swing.border.LineBorder;
import org.verstiukhnutov.swelm.utils.Color;

public class Outline extends Border {
    
    javax.swing.border.Border border;

    public Outline(Color color, int width) {
        border = new LineBorder(color, width);
    }

    @Override
    public javax.swing.border.Border toSwingBorder() {
        return border;
    }
}