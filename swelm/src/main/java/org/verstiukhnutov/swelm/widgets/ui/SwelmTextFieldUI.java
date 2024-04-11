package org.verstiukhnutov.swelm.widgets.ui;

import mdlaf.components.textfield.MaterialTextFieldUI;
import org.verstiukhnutov.swelm.widgets.TextField;
import org.verstiukhnutov.swelm.widgets.swing.JPlaceholderTextField;

import javax.swing.*;
import java.awt.*;

public class SwelmTextFieldUI extends MaterialTextFieldUI {
    private JTextField editor;

    public SwelmTextFieldUI() {
        super(false);
    }

    public void installUI(JComponent c) {
        editor = (JTextField) c;
        super.installUI(c);
    }

    public static SwelmTextFieldUI createUI() {
        return new SwelmTextFieldUI();
    }

    @Override
    protected void paintBackground(Graphics g) {
        g.setColor(editor.getBackground());
        g.fillRoundRect(0, 0, editor.getWidth(), editor.getHeight(), 10, 10);
    }
}
