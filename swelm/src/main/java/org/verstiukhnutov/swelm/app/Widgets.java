package org.verstiukhnutov.swelm.app;

import java.util.HashMap;

import org.verstiukhnutov.swelm.widgets.Widget;

public class Widgets implements IWidgetCollection {

    private HashMap<String, Widget> widgets;

    public Widgets() {
        widgets = new HashMap<>();
    }

    @Override
    public void addWidget(String widgetName, Widget widget) {
        widgets.put(widgetName, widget);
    }

    @Override
    public Widget getWidget(String widgetName) {
        return widgets.get(widgetName);
    }
    
}
