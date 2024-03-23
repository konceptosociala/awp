package org.verstiukhnutov.swelm.widgets.menu;

import java.awt.Component;
import java.awt.event.*;
import javax.swing.JMenuItem;
import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.widgets.ConstructWidget;

public class SingleItem extends MenuItem {

    JMenuItem item;

	public SingleItem(IWidgetCollection widgets, String widgetName) {
		super(widgets, widgetName);
        item = new JMenuItem();
	}

    public SingleItem text(String text) {
        item.setText(text);
        return this;
    }

	public <Msg> SingleItem clicked(ConstructWidget<Msg> app, Msg msg) {
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                app.event(msg);
            }
        });
        return this;
    }

	@Override
	public Component component() {
		return item;
	}
    
}
