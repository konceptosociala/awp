package org.verstiukhnutov.swelm.widgets;

import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JPanel;
import org.verstiukhnutov.swelm.app.IWidgetCollection;

public class Panel extends Widget {

    private JPanel panel;

    public Panel(IWidgetCollection widgets, String widgetName, Widget child) {
		super(widgets, widgetName);
        panel = new JPanel(new GridLayout(1, 1));
		panel.add(child.component());
	}

	public Panel bounds(int x, int y, int width, int height) {
		setBounds(x, y, width, height);
		return this;
	}

	public void setBounds(int x, int y, int width, int height) {
		panel.setBounds(x, y, width, height);
	}

	@Override
	public Component component() {
		return panel;
	}
}
