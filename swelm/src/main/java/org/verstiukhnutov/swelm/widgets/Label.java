package org.verstiukhnutov.swelm.widgets;

import java.awt.*;

import javax.swing.JLabel;
import javax.swing.border.Border;

import mdlaf.components.label.MaterialLabelUI;
import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.utils.Color;
import org.verstiukhnutov.swelm.utils.Pos;
import org.verstiukhnutov.swelm.utils.Size;

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

    public Label fontSize(int size) {
        setFontSize(size);
        return this;
    }

    public Label bold(boolean bold) {
        setBold(bold);
        return this;
    }

    public Label alignmentX(float alignmentX) {
        setAlignmentX(alignmentX);
        return this;
    }

    public Label text(String text) {
        setText(text);
        return this;
    }

    public void setFontSize(int size) {
        label.setFont(label.getFont().deriveFont((float) size));
    }

    public void setBold(boolean bold) {
        label.setFont(label.getFont().deriveFont(bold ? java.awt.Font.BOLD : java.awt.Font.PLAIN));
    }

    public void setAlignmentX(float alignmentX) {
        label.setAlignmentX(alignmentX);
    }

    public void setText(String text) {
        label.setText(text);
    }
    @Override
    public void setSize(Size size) {
        label.setSize(size.width, size.height);
    }

    public void setMaximumSize(Size size) {
        label.setMaximumSize(new Dimension(size.width, size.height));
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
        label.setBorder(border);
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

    public Label maximumSize(Size size) {
        setMaximumSize(size);
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