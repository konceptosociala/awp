package org.verstiukhnutov.swelm.utils.border;

import org.verstiukhnutov.swelm.widgets.swing.RoundedBorder;

public class Rounded extends Border {

    javax.swing.border.Border border;

    public Rounded(int radius) {
        border = new RoundedBorder(radius);
    }

    @Override
    public javax.swing.border.Border toSwingBorder() {
        return border;
    }
}