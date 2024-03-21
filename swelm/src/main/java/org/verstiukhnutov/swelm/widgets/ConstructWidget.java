package org.verstiukhnutov.swelm.widgets;

import java.awt.Component;
import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.app.Widgets;

public abstract class ConstructWidget<Msg> extends Widget implements IWidgetCollection {

    Widgets widgets = new Widgets();

    public ConstructWidget() {
        super(new Widgets(), "application");
    }

    public ConstructWidget(IWidgetCollection widgets, String widgetName) {
        super(widgets, widgetName);
    }

    public abstract Widget build();

    public abstract void event(Msg msg);

    @Override
    public void addWidget(String widgetName, Widget widget) {
        widgets.addWidget(widgetName, widget);
    }

    @Override
    public Widget getWidget(String widgetName) {
        return widgets.getWidget(widgetName);
    }

    @Override
    public Component component() {
        return this.build().component();
    }

}