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

    public HTMLLabel fontSize(int size) {
        label.setFont(label.getFont().deriveFont((float) size));
        return this;
    }

    public HTMLLabel bold(boolean bold) {
        label.setFont(label.getFont().deriveFont(bold ? Font.BOLD : Font.PLAIN));
        return this;
    }

    public HTMLLabel alignmentX(float alignmentX) {
        label.setAlignmentX(alignmentX);
        return this;
    }

    public HTMLLabel text(String text) {
        label.setText(text);
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

    @Override
    public HTMLJLabel component() {
        return label;
    }
}
