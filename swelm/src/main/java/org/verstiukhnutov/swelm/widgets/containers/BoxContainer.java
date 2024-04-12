package org.verstiukhnutov.swelm.widgets.containers;

import java.awt.*;
import javax.swing.Box;
import javax.swing.BoxLayout;
import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.utils.Color;
import org.verstiukhnutov.swelm.utils.Pos;
import org.verstiukhnutov.swelm.utils.Size;
import org.verstiukhnutov.swelm.utils.border.Border;
import org.verstiukhnutov.swelm.widgets.Widget;

public class BoxContainer extends Widget {

    public enum BoxAlign {
        Horizontal,
        Vertical,
    }

    private Box box;

    public BoxContainer(IWidgetCollection widgets, String widgetName) {
        super(widgets, widgetName);
        box = new Box(BoxLayout.X_AXIS);
    }

    public BoxContainer align(BoxAlign align) {
        switch (align) {        
            default:
                break;

            case Vertical:
                box = Box.createVerticalBox();
                break;
        }
        return this;
    }

    public BoxContainer children(Widget[] children) {
        for (Widget widget : children) {
            addChild(widget);
        }
        return this;
    }

    public void addChild(Widget child) {
        box.add(child.component());
    }

    @Override
    public void setVisible(boolean visible) {
        box.setVisible(visible);
    }

    @Override
    public BoxContainer visible(boolean visible) {
        setVisible(visible);
        return this;
    }

    public void setFiller(int width, int height) {
        box.add(Box.createRigidArea(new Dimension(width, height)));
    }
    @Override public void setSize(Size size) {
        box.setSize(size.width, size.height);
    }
    @Override public void setPosition(Pos pos) {}
    @Override public void setBackground(Color color) {}
    @Override public void setForeground(Color color) {}
    @Override public void setBorder(Border border) {}
    public BoxContainer filler(int width, int height) {
        setFiller(width, height);
        return this;
    }
    @Override public BoxContainer size(Size size) {
        setSize(size);
        return this;
    }
    @Override public BoxContainer position(Pos pos) {return this;}
    @Override public BoxContainer background(Color color) {return this;}
    @Override public BoxContainer foreground(Color color) {return this;}
    @Override public BoxContainer border(Border border) {return this;}

    @Override
    public Component component() {
        return box;
    }

}