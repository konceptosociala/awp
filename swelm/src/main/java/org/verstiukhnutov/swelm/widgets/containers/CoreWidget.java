package org.verstiukhnutov.swelm.widgets.containers;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;

import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.widgets.Widget;

public class CoreWidget extends Widget {

    private Container container;

    public CoreWidget(IWidgetCollection widgets, String widgetName, Widget child) {
        super(widgets, widgetName);
        container = new Container();
        container.setLayout(new GridLayout(1, 1));
        container.add(child.component());
    }

    @Override
    public void setVisible(boolean visible) {
        container.setVisible(visible);
    }

    @Override
    public CoreWidget visible(boolean visible) {
        setVisible(visible);
        return this;
    }

    public void setChild(Widget child) {
        container.removeAll();
        container.add(child.component());
    }

    public CoreWidget child(Widget child) {
        setChild(child);
        return this;
    }

    @Override
    public Component component() {
        return container;
    }

}
