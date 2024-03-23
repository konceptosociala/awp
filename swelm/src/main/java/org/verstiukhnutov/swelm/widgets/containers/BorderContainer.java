package org.verstiukhnutov.swelm.widgets.containers;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;

import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.widgets.Widget;

public class BorderContainer extends Widget {

    Container container;

	public BorderContainer(IWidgetCollection widgets, String widgetName) {
		super(widgets, widgetName);
        container = new Container();
        container.setLayout(new BorderLayout());
	}

    public BorderContainer north(Widget widget) {
        container.add(widget.component(), BorderLayout.NORTH);
        return this;
    }

    public BorderContainer south(Widget widget) {
        container.add(widget.component(), BorderLayout.SOUTH);
        return this;
    }

    public BorderContainer east(Widget widget) {
        container.add(widget.component(), BorderLayout.EAST);
        return this;
    }

    public BorderContainer west(Widget widget) {
        container.add(widget.component(), BorderLayout.WEST);
        return this;
    }

    public BorderContainer center(Widget widget) {
        container.add(widget.component(), BorderLayout.CENTER);
        return this;
    }

	@Override
	public Component component() {
		return container;
	}
    
}
