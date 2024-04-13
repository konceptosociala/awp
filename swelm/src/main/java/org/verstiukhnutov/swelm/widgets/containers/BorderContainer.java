package org.verstiukhnutov.swelm.widgets.containers;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;

import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.widgets.Widget;

public class BorderContainer extends Widget {

    private Container container;

    public BorderContainer(IWidgetCollection widgets, String widgetName) {
        super(widgets, widgetName);
        container = new Container();
        container.setLayout(new BorderLayout());
    }

    public BorderContainer north(Widget widget) {
        setNorth(widget);
        return this;
    }

    public BorderContainer south(Widget widget) {
        setSouth(widget);
        return this;
    }

    public BorderContainer east(Widget widget) {
        setEast(widget);
        return this;
    }

    public BorderContainer west(Widget widget) {
        setWest(widget);
        return this;
    }

    public BorderContainer center(Widget widget) {
        setCenter(widget);
        return this;
    }

    public void setNorth(Widget widget) {
        container.add(widget.component(), BorderLayout.NORTH);
    }

    public void setSouth(Widget widget) {
        container.add(widget.component(), BorderLayout.SOUTH);
    }

    public void setEast(Widget widget) {
        container.add(widget.component(), BorderLayout.EAST);
    }

    public void setWest(Widget widget) {
        container.add(widget.component(), BorderLayout.WEST);
    }

    public void setCenter(Widget widget) {
        container.add(widget.component(), BorderLayout.CENTER);
    }

    @Override
    public void setVisible(boolean visible) {
        container.setVisible(visible);
    }

    @Override
    public BorderContainer visible(boolean visible) {
        setVisible(visible);
        return this;
    }

    @Override
    public Component component() {
        return container;
    }
    
}
