package org.verstiukhnutov.swelm.widgets.ui;

import mdlaf.components.textarea.MaterialTextAreaUI;

import javax.swing.*;
import java.awt.*;

public class SwelmTextAreaUI extends MaterialTextAreaUI {
    private JTextArea editor;

    public void installUI(JComponent c) {
        editor = (JTextArea) c;
        super.installUI(c);
    }

    public static SwelmTextAreaUI createUI() {
        return new SwelmTextAreaUI();
    }

    @Override
    protected void paintBackground(Graphics g) {
        g.setColor(editor.getBackground());
        g.fillRoundRect(0, 0, editor.getWidth(), editor.getHeight(), 10, 10);
    }
}
