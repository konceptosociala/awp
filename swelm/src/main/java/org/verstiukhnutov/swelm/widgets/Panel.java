package org.verstiukhnutov.swelm.widgets;

import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JPanel;
import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.utils.Color;
import org.verstiukhnutov.swelm.utils.Pos;
import org.verstiukhnutov.swelm.utils.Size;
import org.verstiukhnutov.swelm.utils.border.Border;

public class Panel extends Widget {

    private JPanel panel;

    public Panel(IWidgetCollection widgets, String widgetName, Widget child) {
        super(widgets, widgetName);
        panel = new JPanel(new GridLayout(1, 1));
        panel.add(child.component());
    }

    @Override
    public void setSize(Size size) {
        panel.setSize(size.width, size.height);
    }

    @Override
    public void setPosition(Pos pos) {
        panel.setLocation(pos.x, pos.y);
    }

    @Override
    public void setBackground(Color color) {
        panel.setBackground(color);
    }

    @Override
    public void setForeground(Color color) {
        panel.setForeground(color);
    }

    @Override
    public void setBorder(Border border) {
        panel.setBorder(border.toSwingBorder());
    }

    @Override
    public void setVisible(boolean visible) {
        panel.setVisible(visible);
    }

    @Override
    public Panel size(Size size) {
        setSize(size);
        return this;
    }

    @Override
    public Panel position(Pos pos) {
        setPosition(pos);
        return this;
    }

    @Override
    public Panel background(Color color) {
        setBackground(color);
        return this;
    }

    @Override
    public Panel foreground(Color color) {
        setForeground(color);
        return this;
    }

    @Override
    public Panel border(Border border) {
        setBorder(border);
        return this;
    }

    @Override
    public Panel visible(boolean visible) {
        setVisible(visible);
        return this;
    }
    
    @Override
    public Component component() {
        return panel;
    }
}
