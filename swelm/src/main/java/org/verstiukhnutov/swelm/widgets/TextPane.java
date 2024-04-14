package org.verstiukhnutov.swelm.widgets;

import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.utils.Size;
import org.verstiukhnutov.swelm.widgets.swing.TruncatingTextPane;

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

    public String getText() {
        return textPane.getText();
    }

    @Override
    public void setAlignmentX(float alignmentX) {
        textPane.setAlignmentX(alignmentX);
    }

    @Override
    public TextPane alignmentX(float alignmentX) {
        setAlignmentX(alignmentX);
        return this;
    }

    @Override
    public void setSize(Size size) {
        textPane.setSize(size.width, size.height);
    }

    @Override
    public TextPane size(Size size) {
        setSize(size);
        return this;
    }

    public void setMaximumSize(Size size) {
        textPane.setMaximumSize(new Dimension(size.width, size.height));
    }

    public TextPane maximumSize(Size size) {
        setMaximumSize(size);
        return this;
    }

    @Override
    public TruncatingTextPane component() {
        return textPane;
    }
}
