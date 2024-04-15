package org.verstiukhnutov.awp.view.widgets;

import org.verstiukhnutov.awp.msg.AwpMsg;
import org.verstiukhnutov.awp.view.AwpApp;
import org.verstiukhnutov.swelm.utils.ResourceImage;
import org.verstiukhnutov.swelm.utils.Size;
import org.verstiukhnutov.swelm.widgets.ConstructWidget;
import org.verstiukhnutov.swelm.widgets.Image;
import org.verstiukhnutov.swelm.widgets.Widget;
import java.io.IOException;

public class Icon extends ConstructWidget<AwpMsg> {
    public enum IconType {
        Pen,
        Trash,
        Cross,
        Plus
    }

    private final AwpApp app;
    private final String widgetName;
    private IconType iconType;
    private Size size;
    private float alignmentX;
    private ConstructWidget<AwpMsg> clickedApp;
    private AwpMsg clickedMsg;


    public Icon(AwpApp app, String widgetName) {
        super(app, widgetName);
        this.app = app;
        this.widgetName = widgetName;
        this.iconType = IconType.Pen;
        this.size = null;
    }

    public Icon type(IconType iconType) {
        this.iconType = iconType;
        return this;
    }

    public Icon clicked(ConstructWidget<AwpMsg> app, AwpMsg msg) {
        this.clickedApp = app;
        this.clickedMsg = msg;
        return this;
    }

    public Icon alignmentX(float alignmentX) {
        this.alignmentX = alignmentX;
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
                            .size(size).alignmentX(alignmentX).clicked(clickedApp, clickedMsg);
                case Trash:
                    return new Image(app, widgetName+"_trash", new ResourceImage(getClass(), "/img/trash.png"))
                            .size(size).alignmentX(alignmentX).clicked(clickedApp, clickedMsg);
                case Cross:
                    return new Image(app, widgetName+"_cross", new ResourceImage(getClass(), "/img/cross.png"))
                            .size(size).alignmentX(alignmentX).clicked(clickedApp, clickedMsg);
                case Plus:
                    return new Image(app, widgetName+"_plus", new ResourceImage(getClass(), "/img/plus.png"))
                            .size(size).alignmentX(alignmentX).clicked(clickedApp, clickedMsg);
            }
        } catch (IOException e) {
            System.err.println("Error loading image: " + e.getMessage());
            return null;
        }
    }
}
