package org.verstiukhnutov.swelm.widgets.menu;

import java.awt.Component;
import javax.swing.JMenuBar;
import javax.swing.border.Border;

import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.utils.Color;
import org.verstiukhnutov.swelm.utils.Pos;
import org.verstiukhnutov.swelm.utils.Size;
import org.verstiukhnutov.swelm.widgets.Widget;

public class MenuBar extends Widget {

    private JMenuBar bar;

    public MenuBar(IWidgetCollection widgets, String widgetName) {
        super(widgets, widgetName);
        bar = new JMenuBar();
    }

    public MenuBar menus(Menu[] menus) {
        for (Menu menu : menus) {
            addMenu(menu);
        }
        return this;
    }

    public void addMenu(Menu menu) {
        bar.add(menu.component());
    }

    @Override
    public void setSize(Size size) {
        bar.setSize(size.width, size.height);
    }

    @Override
    public void setPosition(Pos pos) {
        bar.setLocation(pos.x, pos.y);
    }

    @Override
    public void setBackground(Color color) {
        bar.setBackground(color);
    }

    @Override
    public void setForeground(Color color) {
        bar.setForeground(color);
    }

    @Override
    public void setBorder(Border border) {
        bar.setBorder(border);
    }

    @Override
    public void setVisible(boolean visible) {
        bar.setVisible(visible);
    }

    @Override
    public MenuBar size(Size size) {
        setSize(size);
        return this;
    }

    @Override
    public MenuBar position(Pos pos) {
        setPosition(pos);
        return this;
    }

    @Override
    public MenuBar background(Color color) {
        setBackground(color);
        return this;
    }

    @Override
    public MenuBar foreground(Color color) {
        setForeground(color);
        return this;
    }

    @Override
    public MenuBar border(Border border) {
        setBorder(border);
        return this;
    }

    @Override
    public MenuBar visible(boolean visible) {
        setVisible(visible);
        return this;
    }

    @Override
    public Component component() {
        return bar;
    }
    
}
