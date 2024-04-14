package org.verstiukhnutov.awp.view.widgets;

import org.verstiukhnutov.awp.msg.AwpMsg;
import org.verstiukhnutov.awp.msg.EmptyMsg;
import org.verstiukhnutov.awp.view.AwpApp;
import org.verstiukhnutov.swelm.widgets.ConstructWidget;
import org.verstiukhnutov.swelm.widgets.Widget;
import org.verstiukhnutov.swelm.widgets.menu.MenuItem;
import org.verstiukhnutov.swelm.widgets.menu.Menu;
import org.verstiukhnutov.swelm.widgets.menu.MenuBar;
import org.verstiukhnutov.swelm.widgets.menu.SingleItem;

public class MainMenu extends ConstructWidget<AwpMsg> {

    private AwpApp app;
    private String widgetName;

    public MainMenu(AwpApp app, String widgetName) {
        super(app, widgetName);
        this.app = app;
        this.widgetName = widgetName;
    }

    @Override
    public void event(AwpMsg msg) {
        app.event(msg);
    }
        
    @Override
    public Widget build() {
        return new MenuBar(app, widgetName+"_menu").menus(new Menu[]{
            new Menu(app, widgetName+"_menu_file").text("File").items(new MenuItem[]{
                new SingleItem(app, widgetName+"_menu_new").text("New").clicked(app, new EmptyMsg()),
                new SingleItem(app, widgetName+"_menu_open").text("Open").clicked(app, new EmptyMsg()),
                new Menu(app, widgetName+"_menu_recent").text("Recent").items(new MenuItem[]{
                    new SingleItem(app, widgetName+"_file1").text("file1").clicked(app, new EmptyMsg()),
                    new SingleItem(app, widgetName+"_file2").text("file2").clicked(app, new EmptyMsg()),
                })
            })
        });
    }
        
    public void setVisible(boolean visible) {
        ((MenuBar) app.getWidget(widgetName+"_menu")).setVisible(visible);
    }
}
