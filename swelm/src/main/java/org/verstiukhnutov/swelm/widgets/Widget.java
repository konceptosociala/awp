package org.verstiukhnutov.swelm.widgets;

import java.awt.Component;

import org.verstiukhnutov.swelm.app.IWidgetCollection;

public abstract class Widget {

    public Widget(IWidgetCollection widgets, String widgetName) {
        widgets.addWidget(widgetName, this);
    }

    public abstract Component component();

}
