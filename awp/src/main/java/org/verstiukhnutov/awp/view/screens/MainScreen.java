package org.verstiukhnutov.awp.view.screens;

import org.verstiukhnutov.awp.view.AwpApp;
import org.verstiukhnutov.awp.view.widgets.AddGroup;
import org.verstiukhnutov.awp.view.widgets.MainMenu;
import org.verstiukhnutov.awp.view.widgets.SearchBar;
import org.verstiukhnutov.swelm.utils.Color;
import org.verstiukhnutov.swelm.widgets.Notebook;
import org.verstiukhnutov.swelm.widgets.Panel;
import org.verstiukhnutov.swelm.widgets.ScrollablePanel;
import org.verstiukhnutov.swelm.widgets.Tab;
import org.verstiukhnutov.swelm.widgets.Widget;
import org.verstiukhnutov.swelm.widgets.containers.BorderContainer;
import org.verstiukhnutov.swelm.widgets.containers.WrapContainer;

public class MainScreen extends Screen {
    AwpApp app;
    
    public MainScreen(AwpApp app) {
        super(app, "main_screen");
        this.app = app;
    }

    @Override
    public void init() {
        ((MainMenu) app.getWidget("main_menu")).setVisible(false);
    }

    @Override
    public Widget build() {
        return new BorderContainer(app, "my_border")
            .north(new MainMenu(app, "main_menu"))
            .center(new Notebook(app, "notebook")
                .background(Color.GRAY)
                .foreground(Color.WHITE)
                .tabs(new Tab[]{
                    new Tab("Groups", new ScrollablePanel(app, "groups_panel",
                        new BorderContainer(app, "groups_container")
                            .center(new WrapContainer(app, "groups").children(new Widget[]{
                                new AddGroup(app, "add_group")
                            }))
                    ).background(Color.GRAY)),
                    new Tab("Products", new Panel(app, "products_panel",
                        new BorderContainer(app, "products_container")
                            .north(new SearchBar(app, "products_search")
                                    .placeholder("Enter product name")
                            )
                            .center(new WrapContainer(app, "products"))
                    )),
            }));
    }
}