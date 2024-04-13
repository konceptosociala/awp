package org.verstiukhnutov.swelm.widgets.containers;

import java.awt.*;
import javax.swing.Box;
import javax.swing.BoxLayout;
import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.utils.Size;
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

    public BoxContainer filler(int width, int height) {
        setFiller(width, height);
        return this;
    }
    @Override public BoxContainer size(Size size) {
        setSize(size);
        return this;
    }

    @Override
    public Component component() {
        return box;
    }

}