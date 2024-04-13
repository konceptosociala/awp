package org.verstiukhnutov.swelm.widgets;

import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.widgets.swing.TruncatingTextPane;

import javax.swing.*;
import java.awt.*;

public class TextPane extends Widget {
    private final TruncatingTextPane textPane;

    public TextPane(IWidgetCollection widgets, String widgetName) {
        super(widgets, widgetName);
        textPane = new TruncatingTextPane();
    }

    public void setMaxLines(int maxLines) {
        textPane.setMaxLines(maxLines);
    }

    public TextPane maxLines(int maxLines) {
        setMaxLines(maxLines);
        return this;
    }

    public void setText(String text) {
        textPane.setText(text);
    }

    public TextPane text(String text) {
        setText(text);
        return this;
    }

    @Override
    public void setAlignmentX(float alignmentX) {
        textPane.setAlignmentX(alignmentX);
    }

    public TextPane alignmentX(float alignmentX) {
        setAlignmentX(alignmentX);
        return this;
    }

    @Override
    public Component component() {
        return textPane;
    }
}
