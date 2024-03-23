package org.verstiukhnutov.swelm.widgets.menu;

import java.awt.Component;
import javax.swing.JMenuBar;
import org.verstiukhnutov.swelm.app.IWidgetCollection;
import org.verstiukhnutov.swelm.widgets.Widget;

public class MenuBar extends Widget  {

    JMenuBar bar;

    public MenuBar(IWidgetCollection widgets, String widgetName) {
        super(widgets, widgetName);
        bar = new JMenuBar();
    }

    public MenuBar menus(Menu[] menus) {
        for (Menu menu : menus) {
            bar.add(menu.component());
        }
        return this;
    }

    @Override
    public Component component() {
        return bar;
    }
    
}
