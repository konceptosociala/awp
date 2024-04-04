package org.verstiukhnutov.swelm.widgets;

import java.awt.Component;

import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.utils.AdjustableWidget;

public abstract class Widget implements AdjustableWidget {

    public Widget(IWidgetCollection widgets, String widgetName) {
        widgets.addWidget(widgetName, this);
    }

    public abstract Component component();

}
