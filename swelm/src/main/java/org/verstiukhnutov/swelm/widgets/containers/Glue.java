package org.verstiukhnutov.swelm.widgets.containers;

import java.awt.Component;

import javax.swing.Box;

import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.widgets.Widget;

public class Glue extends Widget {

    public enum Orienation {
        Horizontal,
        Vertical,
    };

    private Component glue;

    public Glue(IWidgetCollection widgets, String widgetName, Orienation orienation) {
        super(widgets, widgetName);
        switch (orienation) {
            case Horizontal:
                glue = Box.createHorizontalGlue();
                break;
        
            case Vertical:
                glue = Box.createVerticalGlue();
                break;
        }
    }

    @Override
    public Component component() {
        return glue;
    }
    
}
