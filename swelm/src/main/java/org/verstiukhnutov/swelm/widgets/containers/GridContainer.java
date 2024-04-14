package org.verstiukhnutov.swelm.widgets.containers;

import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.utils.Color;
import org.verstiukhnutov.swelm.utils.Size;
import org.verstiukhnutov.swelm.widgets.Widget;

import javax.swing.*;
import java.awt.*;

public class GridContainer extends Widget {
    private Container container;
    private int componentMargin = 0;

    public GridContainer(IWidgetCollection widgets, String widgetName, int rows, int columns) {
        super(widgets, widgetName);
        container = new Container();
        container.setLayout(new GridLayout(rows, columns));
    }

    public GridContainer align(BoxContainer.BoxAlign align) {
        switch (align) {
            default:
                break;

            case Vertical:
                container = Box.createVerticalBox();
                break;
        }
        return this;
    }

    public GridContainer children(Widget[] children) {
        for (Widget widget : children) {
            addChild(widget);
        }
        return this;
    }

    public void addChild(Widget child) {
        if (componentMargin > 0 && container.getComponentCount() > 0) {
            container.add(Box.createRigidArea(new Dimension(componentMargin, componentMargin)));
        }
        container.add(child.component());
    }

    @Override
    public void setVisible(boolean visible) {
        container.setVisible(visible);
    }

    @Override
    public GridContainer visible(boolean visible) {
        setVisible(visible);
        return this;
    }

    public void setFiller(int width, int height) {
        container.add(Box.createRigidArea(new Dimension(width, height)));
    }
    @Override public void setSize(Size size) {
        Dimension dSize = new Dimension(size.width, size.height);
        container.setPreferredSize(dSize);
    }

    public GridContainer filler(int width, int height) {
        setFiller(width, height);
        return this;
    }

    @Override public GridContainer size(Size size) {
        setSize(size);
        return this;
    }

    public GridContainer maxSize(Size size) {
        Dimension dSize = new Dimension(size.width, size.height);
        container.setMaximumSize(dSize);
        return this;
    }

    public void setComponentMargin(int margin) {
        componentMargin = margin;
    }

    public GridContainer componentMargin(int margin) {
        setComponentMargin(margin);
        return this;
    }

    @Override
    public void setBackground(org.verstiukhnutov.swelm.utils.Color color) {
        container.setBackground(color);
    }

    @Override
    public GridContainer background(Color color) {
        setBackground(color);
        return this;
    }

    @Override
    public Component component() {
        return container;
    }

}
