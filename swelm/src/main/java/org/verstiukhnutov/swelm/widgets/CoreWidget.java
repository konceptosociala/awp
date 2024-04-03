package org.verstiukhnutov.swelm.widgets;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;

import org.verstiukhnutov.swelm.app.IWidgetCollection;

public class CoreWidget extends Widget {

    private Container container;

    public CoreWidget(IWidgetCollection widgets, String widgetName, Widget child) {
        super(widgets, widgetName);
        container = new Container();
        container.setLayout(new GridLayout(1, 1));
        container.add(child.component());
    }

    @Override
    public Component component() {
        return container;
    }

}
