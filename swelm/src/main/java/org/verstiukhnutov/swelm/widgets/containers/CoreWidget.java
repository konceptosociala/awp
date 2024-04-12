package org.verstiukhnutov.swelm.widgets.containers;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;

import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.utils.Color;
import org.verstiukhnutov.swelm.utils.Pos;
import org.verstiukhnutov.swelm.utils.Size;
import org.verstiukhnutov.swelm.utils.border.Border;
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

    @Override public CoreWidget size(Size size) {return this;}
    @Override public CoreWidget position(Pos pos) {return this;}
    @Override public CoreWidget background(Color color) {return this;}
    @Override public CoreWidget foreground(Color color) {return this;}
    @Override public CoreWidget border(Border border) {return this;}

    @Override
    public Component component() {
        return container;
    }

}
