package org.verstiukhnutov.swelm.widgets;

import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.utils.Color;
import org.verstiukhnutov.swelm.utils.Size;
import org.verstiukhnutov.swelm.widgets.swing.JPlaceholderTextArea;
import org.verstiukhnutov.swelm.widgets.ui.SwelmTextAreaUI;
import java.awt.*;

public class TextArea extends Widget {

    private final JPlaceholderTextArea textArea;

    public TextArea(IWidgetCollection widgets, String widgetName) {
        super(widgets, widgetName);
        textArea = new JPlaceholderTextArea();
        textArea.setUI(new SwelmTextAreaUI());
    }

    public TextArea text(String text) {
        textArea.setText(text);
        return this;
    }

    public String getText() {
        return textArea.getText();
    }

    @Override
    public void setVisible(boolean visible) {
        textArea.setVisible(visible);
    }

    @Override
    public TextArea visible(boolean visible) {
        setVisible(visible);
        return this;
    }

    @Override
    public void setBackground(Color color) {
        textArea.setBackground(color);
    }

    @Override
    public TextArea background(Color color) {
        setBackground(color);
        return this;
    }

    @Override
    public void setAlignmentX(float alignmentX) {
        textArea.setAlignmentX(alignmentX);
    }

    @Override
    public TextArea alignmentX(float alignmentX) {
        setAlignmentX(alignmentX);
        return this;
    }

    public void setPlaceholder(String placeholder) {
        textArea.setPlaceholder(placeholder);
    }

    public TextArea placeholder(String placeholder) {
        setPlaceholder(placeholder);
        return this;
    }

    public void setSize(Size size) {
        textArea.setSize(size.width, size.height);
        textArea.setPreferredSize(new Dimension(size.width, size.height));
    }

    public TextArea size(Size size) {
        setSize(size);
        return this;
    }

    @Override
    public JPlaceholderTextArea component() {
        return textArea;
    }
}
