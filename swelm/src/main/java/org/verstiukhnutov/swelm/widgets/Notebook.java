package org.verstiukhnutov.swelm.widgets;

import java.awt.*;

import javax.swing.JTabbedPane;

import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.utils.Color;
import org.verstiukhnutov.swelm.utils.Pos;
import org.verstiukhnutov.swelm.utils.Size;
import org.verstiukhnutov.swelm.utils.border.Border;
import org.verstiukhnutov.swelm.widgets.ui.SwelmTabbedPaneUI;

public class Notebook extends Widget {

    private final JTabbedPane pane;

    public Notebook(IWidgetCollection widgets, String widgetName) {
        super(widgets, widgetName);

        pane = new JTabbedPane();
        pane.setUI(new SwelmTabbedPaneUI());
    }

    public Notebook tabs(Tab[] tabs) {
        for (Tab tab : tabs) {
            pane.add(tab.getLabel(), tab.getPanel().component());
        }
        return this;
    }

    @Override
    public void setSize(Size size) {
        pane.setSize(size.width, size.height);
    }

    @Override
    public void setPosition(Pos pos) {
        pane.setLocation(pos.x, pos.y);
    }

    @Override
    public void setBackground(Color color) {
        pane.setBackground(color);
    }

    @Override
    public void setForeground(Color color) {
        pane.setForeground(color);
    }

    @Override
    public void setBorder(Border border) {
        pane.setBorder(border.toSwingBorder());
    }

    @Override
    public void setVisible(boolean visible) {
        pane.setVisible(visible);
    }

    @Override
    public Notebook size(Size size) {
        setSize(size);
        return this;
    }

    @Override
    public Notebook position(Pos pos) {
        setPosition(pos);
        return this;
    }

    @Override
    public Notebook background(Color color) {
        setBackground(color);
        return this;
    }

    @Override
    public Notebook foreground(Color color) {
        setForeground(color);
        return this;
    }

    @Override
    public Notebook border(Border border) {
        setBorder(border);
        return this;
    }

    @Override
    public Notebook visible(boolean visible) {
        setVisible(visible);
        return this;
    }

    @Override
    public Component component() {
        return pane;
    }
}
