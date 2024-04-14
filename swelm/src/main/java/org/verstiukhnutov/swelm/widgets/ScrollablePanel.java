package org.verstiukhnutov.swelm.widgets;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.utils.Color;
import org.verstiukhnutov.swelm.utils.Pos;
import org.verstiukhnutov.swelm.utils.Size;

public class ScrollablePanel extends Widget {

    private final JScrollPane panel;

    public ScrollablePanel(IWidgetCollection widgets, String widgetName, Widget child) {
        super(widgets, widgetName);
        panel = new JScrollPane();
        panel.add(child.component());
        panel.getViewport().setView(child.component());
    }

    @Override
    public void setSize(Size size) {
        panel.setMinimumSize(new Dimension(size.width, size.height));
        panel.setPreferredSize(new Dimension(size.width, size.height));
        panel.setMaximumSize(new Dimension(size.width, size.height));
        panel.setSize(size.width, size.height);
    }

    @Override
    public void setPosition(Pos pos) {
        panel.setLocation(pos.x, pos.y);
    }

    @Override
    public void setBackground(Color color) {
        panel.setBackground(color);
        panel.getViewport().setBackground(color);
    }

    @Override
    public void setForeground(Color color) {
        panel.setForeground(color);
        panel.getViewport().setForeground(color);
    }

    @Override
    public void setBorder(Border border) {
        panel.setBorder(border);
    }

    @Override
    public void setVisible(boolean visible) {
        panel.setVisible(visible);
    }

    @Override
    public ScrollablePanel size(Size size) {
        setSize(size);
        return this;
    }

    @Override
    public ScrollablePanel position(Pos pos) {
        setPosition(pos);
        return this;
    }

    @Override
    public ScrollablePanel background(Color color) {
        setBackground(color);
        return this;
    }

    @Override
    public ScrollablePanel foreground(Color color) {
        setForeground(color);
        return this;
    }

    @Override
    public ScrollablePanel border(Border border) {
        setBorder(border);
        return this;
    }

    @Override
    public ScrollablePanel visible(boolean visible) {
        setVisible(visible);
        return this;
    }

    @Override
    public ScrollablePanel alignmentX(float alignmentX) {
        panel.setAlignmentX(alignmentX);
        return this;
    }

    public ScrollablePanel disableHorizontalScrollBar() {
        panel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        return this;
    }

    @Override
    public Component component() {
        return panel;
    }
}
