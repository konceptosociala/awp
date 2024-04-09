package org.verstiukhnutov.awp.view;

import java.io.IOException;
import org.verstiukhnutov.swelm.app.App;
import org.verstiukhnutov.swelm.app.Splashcreen;
import org.verstiukhnutov.swelm.utils.Color;
import org.verstiukhnutov.swelm.utils.MsgBox;
import org.verstiukhnutov.swelm.utils.ResourceImage;
import org.verstiukhnutov.swelm.widgets.*;
import org.verstiukhnutov.swelm.widgets.Panel;
import org.verstiukhnutov.swelm.widgets.containers.*;
import org.verstiukhnutov.awp.model.AwpModel;
import org.verstiukhnutov.awp.view.widgets.*;

public class AwpApp extends ConstructWidget<AwpMsg> {
    
    public AwpModel model;

    @Override
    public void init() {
        try {
            new Splashcreen(
                800, 450, 
                new ResourceImage(getClass(), "/img/splash.png"), 
                3000
            ).show();
        } catch (IOException e) {
            MsgBox.error("I/O Error", e.getMessage());
        }

        ((MainMenu) getWidget("main_menu")).setVisible(false);
    }

    @Override
    public void event(AwpMsg msg) {
        // process msg
    }

    @Override
    public Widget build() {
        return new CoreWidget(this, "my_app",
            new BorderContainer(this, "my_border")
                .north(new MainMenu(this, "main_menu"))
                .center(new Notebook(this, "notebook")
                        .background(Color.GRAY)
                        .foreground(Color.WHITE)
                    .tabs(new Tab[]{
                        new Tab("Groups", new Panel(this, "groups_panel",
                            new BorderContainer(this, "groups_container")
                                .north(new SearchBar(this, "groups_search")
                                    .placeholder("Enter product group name")
                                )
                                .center(new WrapContainer(this, "groups"))
                        )),
                        new Tab("Products", new Panel(this, "products_panel",
                            new BorderContainer(this, "products_container")
                                .north(new SearchBar(this, "products_search")
                                    .placeholder("Enter product name")
                                )
                                .center(new WrapContainer(this, "products"))
                        )),
                }))
        );
    }

    public static void main(String[] args) {
        new App<AwpMsg>(new AwpApp())
            .title("awp64 v0.1")
            .size(1152, 648)
            .position(null)
            .run();
    }

}