package org.verstiukhnutov.awp.view.widgets;

import org.verstiukhnutov.awp.view.AwpApp;
import org.verstiukhnutov.awp.view.AwpMsg;
import org.verstiukhnutov.swelm.utils.ResourceImage;
import org.verstiukhnutov.swelm.utils.Size;
import org.verstiukhnutov.swelm.widgets.ConstructWidget;
import org.verstiukhnutov.swelm.widgets.Image;
import org.verstiukhnutov.swelm.widgets.Widget;

import javax.swing.*;
import java.io.IOException;

public class Icon extends ConstructWidget<AwpMsg> {
    public enum IconType {
        Pen,
        Trash,
        Cross
    }

    private AwpApp app;
    private String widgetName;
    private IconType iconType;
    private Size size;

    public Icon(AwpApp app, String widgetName) {
        super(app, widgetName);
        this.app = app;
        this.widgetName = widgetName;
        this.iconType = IconType.Pen;
    }

    public Icon type(IconType iconType) {
        this.iconType = iconType;
        return this;
    }

    @Override
    public void setSize(Size size) {
        this.size = size;
    }

    public Icon size(Size size) {
        setSize(size);
        return this;
    }

    @Override
    public Widget build() {
        try {
            switch (iconType) {
                default:
                case Pen:
                    return new Image(app, widgetName+"_pen", new ResourceImage(getClass(), "/img/pen.png"))
                            .size(size);
                case Trash:
                    return new Image(app, widgetName+"_trash", new ResourceImage(getClass(), "/img/trash.png"))
                            .size(size);
                case Cross:
                    return new Image(app, widgetName+"_cross", new ResourceImage(getClass(), "/img/cross.png"))
                            .size(size);
            }
        } catch (IOException e) {
            System.err.println("Error loading image: " + e.getMessage());
            return null;
        }
    }
}
