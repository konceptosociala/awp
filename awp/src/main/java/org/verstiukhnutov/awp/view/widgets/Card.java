package org.verstiukhnutov.awp.view.widgets;

import org.verstiukhnutov.awp.view.AwpApp;
import org.verstiukhnutov.awp.view.AwpMsg;
import org.verstiukhnutov.swelm.utils.Color;
import org.verstiukhnutov.swelm.utils.Size;
import org.verstiukhnutov.swelm.utils.border.Rounded;
import org.verstiukhnutov.swelm.widgets.ConstructWidget;
import org.verstiukhnutov.swelm.widgets.Panel;
import org.verstiukhnutov.swelm.widgets.Widget;
import org.verstiukhnutov.swelm.widgets.swing.RoundedBorder;

public class Card extends ConstructWidget<AwpMsg> {
    private AwpApp app;
    private final String widgetName;
    private final Widget child;


    public Card(AwpApp app, String widgetName, Widget child) {
        super(app, widgetName);
        this.app = app;
        this.widgetName = widgetName;
        this.child = child;
    }

    @Override
    public Widget build() {
        return new Panel(app, widgetName+"_panel", child)
                .background(Color.LIGHT_GRAY)
                .size(new Size(504, 243));
    }
}
