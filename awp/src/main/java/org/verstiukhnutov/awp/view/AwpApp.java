package org.verstiukhnutov.awp.view;

import java.io.IOException;

import org.verstiukhnutov.awp.model.Group;
import org.verstiukhnutov.awp.model.GroupName;
import org.verstiukhnutov.awp.model.error.InvalidGroupNameException;
import org.verstiukhnutov.swelm.app.App;
import org.verstiukhnutov.swelm.app.Splashcreen;
import org.verstiukhnutov.swelm.utils.Color;
import org.verstiukhnutov.swelm.utils.MsgBox;
import org.verstiukhnutov.swelm.utils.ResourceImage;
import org.verstiukhnutov.swelm.utils.Size;
import org.verstiukhnutov.swelm.widgets.*;
import org.verstiukhnutov.swelm.widgets.Button;
import org.verstiukhnutov.swelm.widgets.Panel;
import org.verstiukhnutov.swelm.widgets.TextArea;
import org.verstiukhnutov.swelm.widgets.TextField;
import org.verstiukhnutov.swelm.widgets.containers.*;
import org.verstiukhnutov.awp.model.AwpModel;
import org.verstiukhnutov.awp.view.widgets.*;

public class AwpApp extends ConstructWidget<AwpMsg> {

    private static App<AwpMsg> app;
    public AwpModel model = new AwpModel();

    private Widget[] getGroupsWidgets() {
        Widget[] widgets = new Widget[model.getGroups().size() + 1];
        for (int i = 0; i < model.getGroups().size(); i++) {
            widgets[i] = new DisplayGroup(this, "group" + i)
                    .title(model.getGroups().get(i).getName().toString())
                    .description(model.getGroups().get(i).getDescription());
        }
        widgets[model.getGroups().size()] = new AddGroup(this, "add_group");
        return widgets;
    }

    private Widget getNewOrEditGroupScreen(AwpMsg onSave) {
        return getNewOrEditGroupScreen("", "", onSave);
    }

    private Widget getNewOrEditGroupScreen(String name, String description, AwpMsg onSave) {
        return new BoxContainer(this, "new_group_screen")
                .align(BoxContainer.BoxAlign.Vertical)
                .componentMargin(10)
                .children(new Widget[]{
                        new TextField(this, "group_name")
                                .background(Color.LIGHT_GRAY)
                                .placeholder("Enter group name")
                                .text(name)
                                .size(new Size(450, 60)),
                        new TextArea(this, "group_description")
                                .background(Color.LIGHT_GRAY)
                                .placeholder("Enter group description")
                                .text(description)
                                .size(new Size(450, 100)),
                        new Button(this, "create_group")
                                .text("Save")
                                .size(new Size(100, 30))
                                .clicked(this, onSave)
                });
    }

    @Override
    public void init() {
        try {
            new Splashcreen(
                    800, 450,
                    new ResourceImage(getClass(), "/img/splash.png"),
                    100
            ).show();
        } catch (IOException e) {
            MsgBox.error("I/O Error", e.getMessage());
        }

        ((MainMenu) getWidget("main_menu")).setVisible(false);
    }

    @Override
    public void event(AwpMsg msg) {
        System.out.println("Event: " + msg.toString());
        switch (msg.toString()) {
            case "New group":
                ((CoreWidget) getWidget("my_app")).child(getNewOrEditGroupScreen(new AwpMsg("Add group"))).component().revalidate();
                getWidget("my_app").component().repaint();
                break;
            case "Add group":
                try {
                    model.addGroup(
                            new Group(
                                    new GroupName(((TextField) getWidget("group_name")).component().getText()),
                                    ((TextArea) getWidget("group_description")).component().getText()
                            )
                    );
                } catch (InvalidGroupNameException e) {
                    MsgBox.error("Invalid group name", "Group name must start with a capital letter");
                    return;
                }
                ((WrapContainer) getWidget("groups")).children(getGroupsWidgets());
                ((CoreWidget) getWidget("my_app")).child(getWidget("my_border")).component().revalidate();
                getWidget("my_app").component().repaint();
                break;
            case "Edit group":
                String groupName = ((HTMLLabel) getWidget(msg.getAdditionalInfo() + "_title")).component().getText();
                String description = ((TextPane) getWidget(msg.getAdditionalInfo() + "_description")).component().getText();
                ((CoreWidget) getWidget("my_app")).child(getNewOrEditGroupScreen(
                        groupName,
                        description,
                        new AwpMsg("Save group", groupName)
                )).component().revalidate();
                getWidget("my_app").component().repaint();
                break;
            case "Save group":
                try {
                    model.editGroup(
                            model.findGroup(new GroupName(msg.getAdditionalInfo())),
                            new GroupName(((TextField) getWidget("group_name")).component().getText()),
                            ((TextArea) getWidget("group_description")).component().getText()
                    );
                } catch (InvalidGroupNameException e) {
                    MsgBox.error("Invalid group name", "Group name must start with a capital letter");
                    return;
                }
                ((WrapContainer) getWidget("groups")).children(getGroupsWidgets());
                ((CoreWidget) getWidget("my_app")).child(getWidget("my_border")).component().revalidate();
                getWidget("my_app").component().repaint();
            default:
                break;
        }
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
                                                        .center(
                                                                new WrapContainer(this, "groups")
                                                                        .children(getGroupsWidgets())
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