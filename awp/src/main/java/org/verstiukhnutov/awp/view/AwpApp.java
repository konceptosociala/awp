package org.verstiukhnutov.awp.view;

import java.io.IOException;

import org.verstiukhnutov.awp.model.Group;
import org.verstiukhnutov.awp.model.GroupName;
import org.verstiukhnutov.awp.model.error.InvalidGroupNameException;
import org.verstiukhnutov.awp.msg.*;
import org.verstiukhnutov.swelm.app.App;
import org.verstiukhnutov.swelm.app.Splashcreen;
import org.verstiukhnutov.swelm.utils.MsgBox;
import org.verstiukhnutov.swelm.utils.ResourceImage;
import org.verstiukhnutov.swelm.widgets.*;
import org.verstiukhnutov.swelm.widgets.containers.*;
import org.verstiukhnutov.awp.model.AwpModel;
import org.verstiukhnutov.awp.view.screens.EditGroupScreen;
import org.verstiukhnutov.awp.view.screens.MainScreen;
import org.verstiukhnutov.awp.view.screens.Screen;
import org.verstiukhnutov.awp.view.widgets.*;

public class AwpApp extends ConstructWidget<AwpMsg> {

    // Model
    AwpModel model = new AwpModel();
    
    // Screens
    MainScreen mainScreen = new MainScreen(this);
    EditGroupScreen editGroupScreen = new EditGroupScreen(this);

    public static void main(String[] args) {
        new App<AwpMsg>(new AwpApp())
            .title("awp64 v0.1")
            .size(1152, 648)
            .position(null)
            .run();
    }

    @Override
    public void init() {
        splashcreen();
    }

    @Override
    public void event(AwpMsg msg) {
        if (msg instanceof NewGroupMsg) {
            setScreen(editGroupScreen);
            return;
        }
        
        if (msg instanceof AddGroupMsg) {
            String groupName = ((TextField) getWidget("group_name_field")).getText();
            String description = ((TextArea) getWidget("group_description_area")).getText();
            Group group = null;

            try {
                group = new Group(new GroupName(groupName), description);
                model.addGroup(group);
            } catch (InvalidGroupNameException e) {
                MsgBox.error("Invalid group name:\n", e.getMessage());
                return;
            }

            ((WrapContainer) getWidget("groups")).addFirst(new DisplayGroup(this, group));

            setScreen(mainScreen);
            return;
        }

        if (msg instanceof EditGroupMsg) {
            EditGroupMsg msgEdit = (EditGroupMsg) msg;
            DisplayGroup displayGroup = ((DisplayGroup) getWidget(msgEdit.widgetName));

            setScreen(editGroupScreen.with(
                displayGroup.getGroup().getName().toString(), 
                displayGroup.getGroup().getDescription(), 
                new SaveGroupMsg(displayGroup)
            ));
            return;
        }

        if (msg instanceof SaveGroupMsg) {
            SaveGroupMsg msgSave = (SaveGroupMsg) msg;
            String name = ((TextField) getWidget("group_name_field")).getText();
            String description = ((TextArea) getWidget("group_description_area")).getText();

            try {
                msgSave.displayGroup.update(new GroupName(name), description);
            } catch (InvalidGroupNameException e) {
                MsgBox.error("Invalid group name:\n", e.getMessage());
                return;
            }

            setScreen(mainScreen);
            return;
        }

        if (msg instanceof DeleteGroupMsg) {
            DeleteGroupMsg msgDelete = (DeleteGroupMsg) msg;
            Group group = ((DisplayGroup) getWidget(msgDelete.widgetName)).getGroup();
            model.removeGroup(group);

            ((WrapContainer) getWidget("groups")).removeChild(getWidget(msgDelete.widgetName));
            return;
        }
    }

    @Override
    public Widget build() {
        return new CoreWidget(this, "my_app", mainScreen);
    }

    private void setScreen(Screen screen) {
        ((CoreWidget) getWidget("my_app")).setChild(screen);
    }

    private void splashcreen() {
        try {
            new Splashcreen(
                800, 450,
                new ResourceImage(getClass(), "/img/splash.png"),
                100
            ).show();
        } catch (IOException e) {
            MsgBox.error("I/O Error", e.getMessage());
        }
    }
}