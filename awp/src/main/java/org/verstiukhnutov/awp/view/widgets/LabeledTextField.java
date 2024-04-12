package org.verstiukhnutov.awp.view.widgets;

import org.verstiukhnutov.awp.view.AwpApp;
import org.verstiukhnutov.awp.view.AwpMsg;
import org.verstiukhnutov.swelm.utils.Color;
import org.verstiukhnutov.swelm.utils.Size;
import org.verstiukhnutov.swelm.widgets.ConstructWidget;
import org.verstiukhnutov.swelm.widgets.Label;
import org.verstiukhnutov.swelm.widgets.TextField;
import org.verstiukhnutov.swelm.widgets.Widget;
import org.verstiukhnutov.swelm.widgets.containers.BoxContainer;

public class LabeledTextField extends ConstructWidget<AwpMsg> {
    private AwpApp app;
    private String widgetName;
    private String label;
    private String placeholder;
    private Size size;

    public LabeledTextField(AwpApp app, String widgetName) {
        super(app, widgetName);
        this.app = app;
        this.widgetName = widgetName;
        this.label = "";
        this.placeholder = "";
        this.size = new Size(0, 0);
    }

    public LabeledTextField label(String label) {
        this.label = label;
        return this;
    }

    public LabeledTextField placeholder(String placeholder) {
        this.placeholder = placeholder;
        return this;
    }

    public LabeledTextField size(Size size) {
        this.size = size;
        return this;
    }

    @Override
    public Widget build() {
        return new BoxContainer(app, widgetName)
                .align(BoxContainer.BoxAlign.Vertical)
                .filler(size.width, size.height)
                .children(new Widget[]{
                        new Label(app, widgetName + "_label").text(label).foreground(Color.WHITE),
                        new TextField(app, widgetName + "_field").placeholder(placeholder).backgroundColor(Color.LIGHT_GRAY).size(size)
                });
    }
}
