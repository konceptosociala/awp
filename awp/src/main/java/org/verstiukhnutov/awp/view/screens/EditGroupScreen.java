package org.verstiukhnutov.awp.view.screens;

import org.verstiukhnutov.awp.msg.AddGroupMsg;
import org.verstiukhnutov.awp.msg.AwpMsg;
import org.verstiukhnutov.awp.view.AwpApp;
import org.verstiukhnutov.awp.view.widgets.LabeledTextArea;
import org.verstiukhnutov.awp.view.widgets.LabeledTextField;
import org.verstiukhnutov.swelm.utils.Color;
import org.verstiukhnutov.swelm.utils.Size;
import org.verstiukhnutov.swelm.widgets.*;
import org.verstiukhnutov.swelm.widgets.Button;
import org.verstiukhnutov.swelm.widgets.TextArea;
import org.verstiukhnutov.swelm.widgets.containers.BoxContainer;

import java.awt.*;

public class EditGroupScreen extends Screen {
    AwpApp app;
    String name;
    String description;
    AwpMsg onSave;

    @Override
    public void init() {
        rebuild();
    }

    public EditGroupScreen(AwpApp app) {
        this(app, "", "", new AddGroupMsg());
    }

    public EditGroupScreen(AwpApp app, String name, String description, AwpMsg onSave) {
        super(app, "edit_group_screen");
        this.app = app;
        this.name = name;
        this.description = description;
        this.onSave = onSave;
    }

    public EditGroupScreen with(String name, String description, AwpMsg onSave) {
        this.name = name;
        this.description = description;
        this.onSave = onSave;
        return this;
    }

    @Override
    public void event(AwpMsg event) {
        app.event(event);
    }

    @Override
    public Widget build() {
        return new BoxContainer(app, "edit_group_box")
                .align(BoxContainer.BoxAlign.Vertical)
                .padding(10)
                .children(new Widget[]{
                        new LabeledTextField(app, "group_name")
                                .label("Group Name")
                                .placeholder("Enter group name")
                                .text(name)
                                .size(new Size(700, 60))
                                .alignmentX(Component.LEFT_ALIGNMENT),

                        new ScrollablePanel(app, "group_description_panel",
                                new LabeledTextArea(app, "group_description")
                                        .label("Group Description")
                                        .placeholder("Enter group description")
                                        .text(description)
                                        .size(new Size(450, 100))
                                        .alignmentX(Component.LEFT_ALIGNMENT))
                                .background(Color.GRAY)
                                .alignmentX(Component.LEFT_ALIGNMENT)
                                .size(new Size(700, 100)),

                        new Button(app, "create_group")
                                .text("Save")
                                .size(new Size(700, 30))
                                .alignmentX(Component.LEFT_ALIGNMENT)
                                .clicked(this, onSave)
                });
    }

}
