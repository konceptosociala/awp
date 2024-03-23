package org.verstiukhnutov.swelm.widgets.menu;

import java.awt.Component;

import javax.swing.JMenu;

import org.verstiukhnutov.swelm.app.IWidgetCollection;

public class Menu extends MenuItem {

    JMenu menu;

	public Menu(IWidgetCollection widgets, String widgetName) {
		super(widgets, widgetName);
        menu = new JMenu();
	}

    public Menu text(String text) {
        menu.setText(text);
        return this;
    }

    public Menu items(MenuItem[] items) {
        for (MenuItem item : items) {
            menu.add(item.component());
        }
        return this;
    }

	@Override
	public Component component() {
		return menu;
	}
    
}
