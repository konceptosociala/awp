package org.verstiukhnutov.swelm.widgets;

import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.widgets.swing.HTMLJLabel;

import java.awt.*;

public class HTMLLabel extends Widget {
    HTMLJLabel label;

    public HTMLLabel(IWidgetCollection widgets, String widgetName) {
        super(widgets, widgetName);
        label = new HTMLJLabel("");
    }

    public void setFontSize(int size) {
        label.setFont(label.getFont().deriveFont((float) size));
    }

    public HTMLLabel fontSize(int size) {
        setFontSize(size);
        return this;
    }

    public void setBold(boolean bold) {
        label.setFont(label.getFont().deriveFont(bold ? Font.BOLD : Font.PLAIN));
    }

    public HTMLLabel bold(boolean bold) {
        setBold(bold);
        return this;
    }

    public void setAlignmentX(float alignmentX) {
        label.setAlignmentX(alignmentX);
    }

    public HTMLLabel alignmentX(float alignmentX) {
        setAlignmentX(alignmentX);
        return this;
    }

    public void setText(String text) {
        label.setText(text);
    }

    public HTMLLabel text(String text) {
        setText(text);
        return this;
    }

    public HTMLLabel size(int width, int height) {
        label.setPreferredSize(new Dimension(width, height));
        return this;
    }

    public HTMLLabel wrap(boolean wrap) {
        label.setWrapText(wrap);
        return this;
    }

    public String getText() {
        return label.getText();
    }

    @Override
    public HTMLJLabel component() {
        return label;
    }
}
