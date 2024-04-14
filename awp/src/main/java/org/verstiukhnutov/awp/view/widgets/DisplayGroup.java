package org.verstiukhnutov.awp.view.widgets;

import org.verstiukhnutov.awp.model.Group;
import org.verstiukhnutov.awp.model.GroupName;
import org.verstiukhnutov.awp.msg.AwpMsg;
import org.verstiukhnutov.awp.msg.DeleteGroupMsg;
import org.verstiukhnutov.awp.msg.EditGroupMsg;
import org.verstiukhnutov.awp.msg.OpenGroupMsg;
import org.verstiukhnutov.awp.view.AwpApp;
import org.verstiukhnutov.swelm.utils.Size;
import org.verstiukhnutov.swelm.widgets.*;
import org.verstiukhnutov.swelm.widgets.Button;
import org.verstiukhnutov.swelm.widgets.containers.BoxContainer;

import java.awt.*;

public class DisplayGroup extends ConstructWidget<AwpMsg> {
    private final AwpApp app;
    private final String widgetName;
    private Group group;

    public DisplayGroup(AwpApp app, Group group) {
        super(app, "group_" + group.getName().toString().toLowerCase().replaceAll("[ \\-]", "_"));
        this.app = app;
        this.widgetName = "group_" + group.getName().toString().toLowerCase().replaceAll("[ \\-]", "_");
        this.group = group;
    }

    public void update(GroupName name, String description) {
        getGroup().setName(name);
        getGroup().setDescription(description);

        ((HTMLLabel) app.getWidget(widgetName + "_title")).setText(name.toString());
        ((TextPane) app.getWidget(widgetName + "_description")).setText(truncateDescription(description, 400));
    }

    private String truncateDescription(String description, int length) {
        if (description.length() <= length) {
            return description;
        } else {
            return description.substring(0, length)+"...";
        }
    }

    public Group getGroup() {
        return group;
    }

    @Override
    public Widget build() {
        return new Card(app, widgetName + "_card",
            new BoxContainer(app, widgetName + "_box")
                .align(BoxContainer.BoxAlign.Vertical)
                .size(new Size(504, 243))
                .componentMargin(10)
                .children(new Widget[]{
                    new BoxContainer(app, widgetName + "_title_box")
                        .align(BoxContainer.BoxAlign.Horizontal)
                        .alignmentX(Component.LEFT_ALIGNMENT)
                        .componentMargin(10)
                        .size(new Size(504, 24))
                        .children(new Widget[]{
                            new HTMLLabel(app, widgetName + "_title").text(group.getName().toString())
                                .fontSize(16)
                                .bold(true)
                                .size(400, 24),

                            new Icon(app, widgetName + "_edit")
                                .type(Icon.IconType.Pen)
                                .size(new Size(20, 20))
                                .clicked(app, new EditGroupMsg(widgetName)),

                            new Icon(app, widgetName + "_delete")
                                .type(Icon.IconType.Trash)
                                .size(new Size(17, 20))
                                .clicked(app, new DeleteGroupMsg(widgetName)),
                        }),

                        new TextPane(app, widgetName + "_description")
                                .maxLines(6)
                                .text(truncateDescription(group.getDescription(), 400))
                                .size(new Size(504, 120))
                                .maximumSize(new Size(504, 120))
                                .alignmentX(Component.LEFT_ALIGNMENT),
                        
                        new Button(app, widgetName + "_button")
                            .text("Open")
                            .size(new Size(100, 30))
                            .alignmentX(Component.LEFT_ALIGNMENT)
                            .clicked(app, new OpenGroupMsg(group)),
                })
        );
    }
}
