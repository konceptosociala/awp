package org.verstiukhnutov.awp.ui.widgets;

import org.verstiukhnutov.awp.ui.AwpApp;
import org.verstiukhnutov.awp.ui.AwpMsg;
import org.verstiukhnutov.swelm.widgets.ConstructWidget;
import org.verstiukhnutov.swelm.widgets.Widget;
import org.verstiukhnutov.swelm.widgets.menu.MenuItem;
import org.verstiukhnutov.swelm.widgets.menu.Menu;
import org.verstiukhnutov.swelm.widgets.menu.MenuBar;
import org.verstiukhnutov.swelm.widgets.menu.SingleItem;

public class MainMenu extends ConstructWidget<AwpMsg> {

    AwpApp app;

    public MainMenu(AwpApp app, String widgetName) {
        super(app, widgetName);
        this.app = app;
    }

    @Override
    public void event(AwpMsg msg) {
        app.event(msg);
    }
        
    @Override
    public Widget build() {
        return new MenuBar(app, "menu").menus(new Menu[]{
            new Menu(app, "menu_file").text("File").items(new MenuItem[]{
                new SingleItem(app, "menu_new").text("New").clicked(app, new AwpMsg("New")),
                new SingleItem(app, "menu_open").text("Open").clicked(app, new AwpMsg("Open")),
                new Menu(app, "menu_recent").text("Recent").items(new MenuItem[]{
                    new SingleItem(app, "file1").text("file1").clicked(app, new AwpMsg("File2")),
                    new SingleItem(app, "file2").text("file2").clicked(app, new AwpMsg("File1")),
                })
            })
        });
    }
        
    public void setVisible(boolean visible) {
        ((MenuBar) app.getWidget("menu")).setVisible(visible);
    }
}
