package org.verstiukhnutov.swelm.widgets;

import java.awt.Component;

import javax.swing.JLabel;

import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.utils.Color;
import org.verstiukhnutov.swelm.utils.Pos;
import org.verstiukhnutov.swelm.utils.Size;
import org.verstiukhnutov.swelm.utils.border.Border;

public class Label extends Widget {

    public enum TextAlign {
        Left,
        Right,
        Center
    }

    JLabel label;

    public Label(IWidgetCollection widgets, String widgetName) {
        super(widgets, widgetName);
        label = new JLabel();
    }

    public Label text(String text) {
        setText(text);
        return this;
    }

    public void setText(String text) {
        label.setText(text);
    }

    @Override
    public void setSize(Size size) {
        label.setSize(size.width, size.height);
    }

    @Override
    public void setPosition(Pos pos) {
        label.setLocation(pos.x, pos.y);
    }

    @Override
    public void setBackground(Color color) {
        label.setBackground(color);
    }

    @Override
    public void setForeground(Color color) {
        label.setForeground(color);
    }

    @Override
    public void setBorder(Border border) {
        label.setBorder(border.toSwingBorder());
    }

    @Override
    public void setVisible(boolean visible) {
        label.setVisible(visible);
    }

    @Override
    public Label size(Size size) {
        setSize(size);
        return this;
    }

    @Override
    public Label position(Pos pos) {
        setPosition(pos);
        return this;
    }

    @Override
    public Label background(Color color) {
        setBackground(color);
        return this;
    }

    @Override
    public Label foreground(Color color) {
        setForeground(color);
        return this;
    }

    @Override
    public Label border(Border border) {
        setBorder(border);
        return this;
    }

    @Override
    public Label visible(boolean visible) {
        setVisible(visible);
        return this;
    }

    @Override
    public Component component() {
        return label;
    }

}