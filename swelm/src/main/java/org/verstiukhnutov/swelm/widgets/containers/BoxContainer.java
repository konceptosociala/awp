package org.verstiukhnutov.swelm.widgets.containers;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.utils.Color;
import org.verstiukhnutov.swelm.utils.Size;
import org.verstiukhnutov.swelm.widgets.Widget;

public class BoxContainer extends Widget {

    public enum BoxAlign {
        Horizontal,
        Vertical,
    }

    private Box box;
    private int componentMargin = 0;

    public BoxContainer(IWidgetCollection widgets, String widgetName) {
        super(widgets, widgetName);
        box = new Box(BoxLayout.X_AXIS);
    }

    public BoxContainer align(BoxAlign align) {
        switch (align) {
            default:
                break;

            case Vertical:
                box = Box.createVerticalBox();
                break;
        }
        return this;
    }

    public BoxContainer children(Widget[] children) {
        for (Widget widget : children) {
            addChild(widget);
        }
        box.revalidate();
        box.repaint();
        return this;
    }

    public void addChild(Widget child) {
        if (componentMargin > 0 && box.getComponentCount() > 0) {
            box.add(Box.createRigidArea(new Dimension(componentMargin, componentMargin)));
        }
        box.add(child.component());
        box.revalidate();
        box.repaint();
    }

    public void removeChildren() {
        box.removeAll();
        box.revalidate();
        box.repaint();
    }

    @Override
    public void setVisible(boolean visible) {
        box.setVisible(visible);
    }

    @Override
    public BoxContainer visible(boolean visible) {
        setVisible(visible);
        return this;
    }

    public void setFiller(int width, int height) {
        box.add(Box.createRigidArea(new Dimension(width, height)));
    }
    @Override public void setSize(Size size) {
        box.setSize(size.width, size.height);
        Dimension dSize = new Dimension(size.width, size.height);
        box.setPreferredSize(dSize);
        box.setMinimumSize(dSize);
        box.setMaximumSize(dSize);
    }

    public BoxContainer filler(int width, int height) {
        setFiller(width, height);
        return this;
    }

    public void setPadding(int padding) {
        box.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
    }

    public BoxContainer padding(int padding) {
        setPadding(padding);
        return this;
    }

    @Override public BoxContainer size(Size size) {
        setSize(size);
        return this;
    }

    @Override
    public BoxContainer alignmentX(float alignmentX) {
        box.setAlignmentX(alignmentX);
        return this;
    }

    public void setComponentMargin(int margin) {
        componentMargin = margin;
    }

    public BoxContainer componentMargin(int margin) {
        setComponentMargin(margin);
        return this;
    }

    @Override
    public void setBackground(Color color) {
        box.setBackground(color);
    }

    @Override
    public BoxContainer background(Color color) {
        setBackground(color);
        return this;
    }

    @Override
    public BoxContainer border(Border border) {
        box.setBorder(border);
        return this;
    }

    @Override
    public Component component() {
        return box;
    }

}