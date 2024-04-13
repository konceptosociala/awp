package org.verstiukhnutov.swelm.widgets.menu;

import java.awt.Component;

import javax.swing.JMenu;
import javax.swing.border.Border;

import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.utils.Color;
import org.verstiukhnutov.swelm.utils.Pos;
import org.verstiukhnutov.swelm.utils.Size;

public class Menu extends MenuItem {

    private JMenu menu;

    public Menu(IWidgetCollection widgets, String widgetName) {
        super(widgets, widgetName);
        menu = new JMenu();
    }

    public Menu text(String text) {
        setText(text);
        return this;
    }

    public Menu items(MenuItem[] items) {
        for (MenuItem item : items) {
            addItem(item);
        }
        return this;
    }

    public void setText(String text) {
        menu.setText(text);
    }

    public void addItem(MenuItem item) {
        menu.add(item.component());
    }

    @Override
    public void setVisible(boolean visible) {
        menu.setVisible(visible);
    }

    @Override
    public void setSize(Size size) {
        menu.setSize(size.width, size.height);
    }

    @Override
    public void setPosition(Pos pos) {
        menu.setLocation(pos.x, pos.y);
    }

    @Override
    public void setBackground(Color color) {
        menu.setBackground(color);
    }

    @Override
    public void setForeground(Color color) {
        menu.setForeground(color);
    }

    @Override
    public void setBorder(Border border) {
        menu.setBorder(border);
    }

    @Override
    public Menu visible(boolean visible) {
        setVisible(visible);
        return this;
    }

    @Override
    public Menu size(Size size) {
        setSize(size);
        return this;
    }

    @Override
    public Menu position(Pos pos) {
        setPosition(pos);
        return this;
    }

    @Override
    public Menu background(Color color) {
        setBackground(color);
        return this;
    }

    @Override
    public Menu foreground(Color color) {
        setForeground(color);
        return this;
    }

    @Override
    public Menu border(Border border) {
        setBorder(border);
        return this;
    }

    @Override
    public Component component() {
        return menu;
    }
    
}
