package org.verstiukhnutov.awp.view.screens;

import org.verstiukhnutov.awp.msg.AddGroupMsg;
import org.verstiukhnutov.awp.msg.AwpMsg;
import org.verstiukhnutov.awp.view.AwpApp;
import org.verstiukhnutov.swelm.utils.Color;
import org.verstiukhnutov.swelm.utils.Size;
import org.verstiukhnutov.swelm.widgets.Button;
import org.verstiukhnutov.swelm.widgets.TextArea;
import org.verstiukhnutov.swelm.widgets.TextField;
import org.verstiukhnutov.swelm.widgets.Widget;
import org.verstiukhnutov.swelm.widgets.containers.BoxContainer;

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
            .componentMargin(10)
            .children(new Widget[]{
                new TextField(app, "group_name")
                    .background(Color.LIGHT_GRAY)
                    .placeholder("Enter group name")
                    .text(name)
                    .size(new Size(450, 60)),

                new TextArea(app, "group_description")
                    .background(Color.LIGHT_GRAY)
                    .placeholder("Enter group description")
                    .text(description)
                    .size(new Size(450, 100)),
                    
                new Button(app, "create_group")
                    .text("Save")
                    .size(new Size(100, 30))
                    .clicked(this, onSave)
            });
    }
    
}
