package org.verstiukhnutov.awp.ui;

import org.verstiukhnutov.swelm.app.App;
import org.verstiukhnutov.swelm.widgets.*;
import org.verstiukhnutov.swelm.widgets.containers.BorderContainer;
import org.verstiukhnutov.awp.ui.widgets.MainMenu;

public class AwpApp extends ConstructWidget<AwpMsg> {   

    @Override
    public void init() {
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
                .center(
                    new Notebook(this, "notebook")
                        .tabs(new Tab[]{
                            new Tab("Groups", new Panel(this, "groups_panel",
                                new Button(this, "btn1")
                                    .text("Groups")
                            )),
                            new Tab("Wares", new Panel(this, "wares_panel",
                                new Button(this, "btn2")
                                    .text("Wares")
                            )),
                        })
                )
        );
    }

    public static void main(String[] args) {
        new App<AwpMsg>(new AwpApp())
            .title("awp64 v0.1")
            .size(1024, 576)
            .run();
    }

}