package org.verstiukhnutov.swelm.widgets.containers;

import java.awt.Component;
import java.awt.Container;
import java.util.Arrays;

import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.widgets.Widget;
import org.verstiukhnutov.swelm.widgets.swing.WrapLayout;

public class WrapContainer extends Widget {
    
    private Container container;

    public WrapContainer(IWidgetCollection widgets, String widgetName) {
        super(widgets, widgetName);
        container = new Container();
        container.setLayout(new WrapLayout());
    }

    public WrapContainer children(Widget[] children) {
        container.removeAll();
        for (Widget widget : children) {
            addChild(widget);
        }
        return this;
    }

    public void addChild(Widget child) {
        container.add(child.component());
        container.revalidate();
        container.repaint();
    }

    public void addFirst(Widget child) {
        Component[] comps = container.getComponents();
        container.removeAll();
        container.add(child.component());
        Arrays.stream(comps).forEach((c) -> container.add(c));

        container.revalidate();
        container.repaint();
    }

    public void removeChild(Widget child) {
        container.remove(child.component());
        container.revalidate();
        container.repaint();
    }

    @Override
    public void setVisible(boolean visible) {
        container.setVisible(visible);
    }

    @Override
    public WrapContainer visible(boolean visible) {
        setVisible(visible);
        return this;
    }

    @Override
    public Component component() {
        return container;
    }

}
