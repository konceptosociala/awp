package org.verstiukhnutov.awp.view.widgets;

import org.verstiukhnutov.awp.view.AwpApp;
import org.verstiukhnutov.awp.view.AwpMsg;
import org.verstiukhnutov.swelm.utils.Size;
import org.verstiukhnutov.swelm.widgets.ConstructWidget;
import org.verstiukhnutov.swelm.widgets.Label;
import org.verstiukhnutov.swelm.widgets.Widget;
import org.verstiukhnutov.swelm.widgets.containers.BoxContainer;

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

    public DisplayGroup title(String title) {
        this.title = title;
        return this;
    }

    public DisplayGroup description(String description) {
        this.description = description;
        return this;
    }

    @Override
    public Widget build() {
        return new Card(app, widgetName + "_card",
                new BoxContainer(app, widgetName + "_box")
                        .align(BoxContainer.BoxAlign.Vertical)
                        .size(new Size(504, 243))
                        .filler(504, 243)
                        .children(new Widget[]{
                                new Label(app, widgetName + "_title").text(title),
                                new Label(app, widgetName + "_description").text(description)
                        })
        ).build();
    }
}
