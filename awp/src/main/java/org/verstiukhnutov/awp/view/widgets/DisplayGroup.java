package org.verstiukhnutov.awp.view.widgets;

import org.verstiukhnutov.awp.view.AwpApp;
import org.verstiukhnutov.awp.view.AwpMsg;
import org.verstiukhnutov.swelm.utils.Size;
import org.verstiukhnutov.swelm.widgets.*;
import org.verstiukhnutov.swelm.widgets.Button;
import org.verstiukhnutov.swelm.widgets.containers.BoxContainer;

import java.awt.*;

public class DisplayGroup extends ConstructWidget<AwpMsg> {
    private final AwpApp app;
    private final String widgetName;
    private String title;
    private String description;

    public DisplayGroup(AwpApp app, String widgetName) {
        super(app, widgetName);
        this.app = app;
        this.widgetName = widgetName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DisplayGroup title(String title) {
        this.setTitle(title);
        return this;
    }

    public DisplayGroup description(String description) {
        this.setDescription(description);
        return this;
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
                                                new HTMLLabel(app, widgetName + "_title").text(title)
                                                        .fontSize(16)
                                                        .bold(true)
                                                        .size(400, 24),
                                                new Icon(app, widgetName + "_edit")
                                                        .type(Icon.IconType.Pen)
                                                        .size(new Size(20, 20))
                                                        .clicked(app, new AwpMsg("Edit group", widgetName)),
                                                new Icon(app, widgetName + "_delete")
                                                        .type(Icon.IconType.Trash)
                                                        .size(new Size(17, 20))
                                                        .clicked(app, new AwpMsg("Delete group", widgetName)),
                                        }),
                                new TextPane(app, widgetName + "_description").text(description).alignmentX(Component.LEFT_ALIGNMENT),
                                new Button(app, widgetName + "_button")
                                        .text("Open")
                                        .size(new Size(100, 30))
                                        .alignmentX(Component.LEFT_ALIGNMENT)
                                        .clicked(app, new AwpMsg("Open")),
                        })
        ).build();
    }
}
