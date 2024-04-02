package org.verstiukhnutov.swelm.widgets;

import java.awt.Component;

import org.verstiukhnutov.swelm.app.DumpMode;
import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.app.Widgets;

public abstract class ConstructWidget<Msg> extends Widget implements IWidgetCollection {

    private Widgets widgets = new Widgets();

    public ConstructWidget() {
        super(new Widgets(), "application");
    }

    public ConstructWidget(IWidgetCollection widgets, String widgetName) {
        super(widgets, widgetName);
    }

    public abstract Widget build();

    public void init() {}

    public void event(Msg msg) {}

    public final void dumpWidgets(DumpMode mode) {
        widgets.dumpWidgets(mode);
    }

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
        Widget built = this.build();
        init();
        return built.component();
    }

}