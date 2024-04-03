package org.verstiukhnutov.swelm.widgets;

import java.awt.Component;

import javax.swing.JLabel;

import org.verstiukhnutov.swelm.app.IWidgetCollection;

public class Label extends Widget {

    public enum TextAlign {
        Left,
        Right,
        Center
    }

    JLabel label;

    public Label(IWidgetCollection widgets, String widgetName) {
        super(widgets, widgetName);
        label = new JLabel();
    }

    public Label text(String text) {
        setText(text);
        return this;
    }

    public Label align(TextAlign align) {
        setAlign(align);
        return this;
    }

    public void setAlign(TextAlign align) {
        switch (align) {
            case Left:
                label.setAlignmentX(JLabel.LEFT_ALIGNMENT);
                break;
        
            case Right:
                label.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
                break;

            case Center:
                label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
                break;

            default:
                break;
        }
    }

    public void setText(String text) {
        label.setText(text);
    }

    @Override
    public Component component() {
        return label;
    }

}