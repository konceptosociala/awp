package org.verstiukhnutov.swelm.widgets.menu;

import java.awt.Component;
import javax.swing.JMenuBar;
import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.widgets.Widget;

public class MenuBar extends Widget  {

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

    public void setVisible(boolean visible) {
        bar.setVisible(visible);
    }

    @Override
    public Component component() {
        return bar;
    }
    
}
