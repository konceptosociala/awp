package org.verstiukhnutov.awp.view;

import java.io.IOException;
import org.verstiukhnutov.swelm.app.App;
import org.verstiukhnutov.swelm.app.Splashcreen;
import org.verstiukhnutov.swelm.utils.Color;
import org.verstiukhnutov.swelm.utils.MsgBox;
import org.verstiukhnutov.swelm.utils.ResourceImage;
import org.verstiukhnutov.swelm.utils.Size;
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
                        new Tab("Groups", new ScrollablePanel(this, "groups_panel",
                            new BorderContainer(this, "groups_container")
                                .north(new SearchBar(this, "groups_search")
                                    .placeholder("Enter product group name")
                                )
                                .center(
                                        new WrapContainer(this, "groups")
                                                .size(new Size(1152, 648))
                                                .children(new Card[]{new Card(this, "group1", new Label(this, "group1_label").text("Group 1")),
                                                        new Card(this, "group2", new Label(this, "group2_label").text("Group 2")),
                                                        new Card(this, "group3", new Label(this, "group3_label").text("Group 3")),
                                                        new Card(this, "group4", new Label(this, "group4_label").text("Group 4")),
                                                        new Card(this, "group5", new Label(this, "group5_label").text("Group 5")),
                                                        new Card(this, "group6", new Label(this, "group6_label").text("Group 6")),
                                                        new Card(this, "group7", new Label(this, "group7_label").text("Group 7")),
                                                        new Card(this, "group8", new Label(this, "group8_label").text("Group 8")),
                                                        new Card(this, "group9", new Label(this, "group9_label").text("Group 9")),
                                                        new Card(this, "group10", new Label(this, "group10_label").text("Group 10")),
                                                        new Card(this, "group11", new Label(this, "group11_label").text("Group 11")),
                                                        new Card(this, "group12", new Label(this, "group12_label").text("Group 12")),
                                                        new Card(this, "group13", new Label(this, "group13_label").text("Group 13")),
                                                        new Card(this, "group14", new Label(this, "group14_label").text("Group 14")),
                                                        new Card(this, "group15", new Label(this, "group15_label").text("Group 15")),
                                                        new Card(this, "group16", new Label(this, "group16_label").text("Group 16")),
                                                        new Card(this, "group17", new Label(this, "group17_label").text("Group 17")),
                                                        new Card(this, "group18", new Label(this, "group18_label").text("Group 18")),
                                                        new Card(this, "group19", new Label(this, "group19_label").text("Group 19")),
                                                        new Card(this, "group20", new Label(this, "group20_label").text("Group 20")),
                                                        new Card(this, "group21", new Label(this, "group21_label").text("Group 21")),
                                                })
                                )
                        ).background(Color.GRAY)),
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