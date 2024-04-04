package org.verstiukhnutov.swelm.widgets;

import java.awt.Component;

import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.app.Widgets;
import org.verstiukhnutov.swelm.utils.Color;
import org.verstiukhnutov.swelm.utils.DumpMode;
import org.verstiukhnutov.swelm.utils.Pos;
import org.verstiukhnutov.swelm.utils.Size;
import org.verstiukhnutov.swelm.utils.border.Border;

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

    @Override public void setSize(Size size) {}
    @Override public void setPosition(Pos pos) {}
    @Override public void setBackground(Color color) {}
    @Override public void setForeground(Color color) {}
    @Override public void setBorder(Border border) {}
    @Override public void setVisible(boolean visible) {}
    @Override public ConstructWidget<Msg> size(Size size) {return this;}
    @Override public ConstructWidget<Msg> position(Pos pos) {return this;}
    @Override public ConstructWidget<Msg> background(Color color) {return this;}
    @Override public ConstructWidget<Msg> foreground(Color color) {return this;}
    @Override public ConstructWidget<Msg> border(Border border) {return this;}
    @Override public ConstructWidget<Msg> visible(boolean visible) {return this;}

}