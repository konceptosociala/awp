package org.verstiukhnutov.swelm.widgets;

import java.awt.Component;

import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.app.Widgets;
import org.verstiukhnutov.swelm.utils.Color;
import org.verstiukhnutov.swelm.utils.DumpMode;
import org.verstiukhnutov.swelm.utils.Pos;
import org.verstiukhnutov.swelm.utils.Size;

import javax.swing.border.Border;

public abstract class ConstructWidget<Msg> extends Widget implements IWidgetCollection {

    private Widgets widgets = new Widgets();

    private Widget built = null;

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

    protected final void rebuild() {
        built = this.build();
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
        if (built == null){
            rebuild();
        }

        init();
        
        return built.component();
    }

    @Override public ConstructWidget<Msg> size(Size size) {return this;}
    @Override public ConstructWidget<Msg> position(Pos pos) {return this;}
    @Override public ConstructWidget<Msg> background(Color color) {return this;}
    @Override public ConstructWidget<Msg> foreground(Color color) {return this;}
    @Override public ConstructWidget<Msg> border(Border border) {return this;}
    @Override public ConstructWidget<Msg> visible(boolean visible) {return this;}

}