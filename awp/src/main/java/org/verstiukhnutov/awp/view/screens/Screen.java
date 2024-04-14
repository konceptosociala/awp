package org.verstiukhnutov.awp.view.screens;

import org.verstiukhnutov.awp.msg.AwpMsg;
import org.verstiukhnutov.awp.view.AwpApp;
import org.verstiukhnutov.swelm.widgets.ConstructWidget;

public abstract class Screen extends ConstructWidget<AwpMsg> {
    public Screen(AwpApp app, String screenName) {
        super(app, screenName);
    }
}
