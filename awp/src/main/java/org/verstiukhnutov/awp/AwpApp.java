package org.verstiukhnutov.awp;

import org.verstiukhnutov.swelm.app.App;
import org.verstiukhnutov.swelm.widgets.*;
import org.verstiukhnutov.swelm.widgets.containers.BorderContainer;
import org.verstiukhnutov.swelm.widgets.menu.Menu;
import org.verstiukhnutov.swelm.widgets.menu.MenuBar;
import org.verstiukhnutov.swelm.widgets.menu.MenuItem;
import org.verstiukhnutov.swelm.widgets.menu.SingleItem;

class AwpMsg {
    String msg = "";

    public AwpMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}

public class AwpApp extends ConstructWidget<AwpMsg> {    
    int i = 0;

    public static void main(String[] args) {
        new App<AwpMsg>(new AwpApp())
            .title("awp64 v0.1")
            .size(800, 600)
            .run();
    }

    @Override
    public void event(AwpMsg msg) {
        Button button = (Button) getWidget("my_button");
        button.text(msg.toString());
    }

    @Override
    public Widget build() {
        return new CoreWidget(this, "my_app",
            new BorderContainer(this, "my_border")
                .north(
                    new MenuBar(this, "menu").menus(new Menu[]{
                        new Menu(this, "menu_file").text("File").items(new MenuItem[]{
                            new SingleItem(this, "menu_new").text("New").clicked(this, new AwpMsg("New")),
                            new SingleItem(this, "menu_open").text("Open").clicked(this, new AwpMsg("Open")),
                            new Menu(this, "menu_recent").text("Recent").items(new MenuItem[]{
                                new SingleItem(this, "file1").text("file1").clicked(this, new AwpMsg("File2")),
                                new SingleItem(this, "file2").text("file2").clicked(this, new AwpMsg("File1")),
                            })
                        })
                    })
                )
                .center(
                    new Button(this, "my_button")
                        .text(String.valueOf(i))
                        .bounds(0, 0, 100, 40)
                )
                .west(
                    new Button(this, "inc")
                        .text("Increment")
                        .bounds(0, 0, 100, 40)
                        .clicked(this, new AwpMsg("Increment"))
                )
        );
    }

}