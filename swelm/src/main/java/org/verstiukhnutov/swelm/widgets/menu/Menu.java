package org.verstiukhnutov.swelm.widgets.menu;

import java.awt.Component;

import javax.swing.JMenu;

import org.verstiukhnutov.swelm.app.IWidgetCollection;

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
    public Component component() {
        return menu;
    }
    
}
