package org.verstiukhnutov.swelm.widgets;

import java.awt.Component;

import javax.swing.JTabbedPane;

import org.verstiukhnutov.swelm.app.IWidgetCollection;

public class Notebook extends Widget {

    private JTabbedPane pane;

    public Notebook(IWidgetCollection widgets, String widgetName) {
		super(widgets, widgetName);
        pane = new JTabbedPane();
	}

	public Notebook bounds(int x, int y, int width, int height) {
		setBounds(x, y, width, height);
		return this;
	}

    public Notebook tabs(Tab[] tabs) {
        for (Tab tab : tabs) {
            pane.add(tab.getLabel(), tab.getPanel().component());
        }
        return this;
    }

	public void setBounds(int x, int y, int width, int height) {
		pane.setBounds(x, y, width, height);
	}

	@Override
	public Component component() {
		return pane;
	}
}
