package org.verstiukhnutov.swelm.utils.border;

import javax.swing.border.EmptyBorder;

public class Empty extends Border {

    javax.swing.border.Border border;

    public Empty() {
        border = new EmptyBorder(0, 0, 0, 0);
    }

    @Override
    public javax.swing.border.Border toSwingBorder() {
        return border;
    }
}
