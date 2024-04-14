package org.verstiukhnutov.swelm.widgets;

import java.awt.Component;
import javax.swing.border.Border;

import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.utils.AdjustableWidget;
import org.verstiukhnutov.swelm.utils.Color;
import org.verstiukhnutov.swelm.utils.Pos;
import org.verstiukhnutov.swelm.utils.Size;

public abstract class Widget implements AdjustableWidget {

    public Widget(IWidgetCollection widgets, String widgetName) {
        widgets.addWidget(widgetName, this);
    }

    public abstract Component component();

    @Override public void setSize(Size size) {}
    @Override public void setPosition(Pos pos) {}
    @Override public void setBackground(Color color) {}
    @Override public void setForeground(Color color) {}
    @Override public void setBorder(Border border) {}
    @Override public void setAlignmentX(float alignmentX) {}
    @Override public void setAlignmentY(float alignmentY) {}
    @Override public void setVisible(boolean visible) {};

    @Override public Widget size(Size size) {return this;}
    @Override public Widget position(Pos pos) {return this;}
    @Override public Widget background(Color color) {return this;}
    @Override public Widget foreground(Color color) {return this;}
    @Override public Widget border(Border border) {return this;}
    @Override public Widget alignmentX(float alignmentX) {return this;}
    @Override public Widget alignmentY(float alignmentY) {return this;}
    @Override public Widget visible(boolean visible) {return this;}
}
