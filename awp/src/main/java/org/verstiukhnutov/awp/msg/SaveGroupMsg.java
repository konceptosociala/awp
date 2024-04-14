package org.verstiukhnutov.awp.msg;

import org.verstiukhnutov.awp.view.widgets.DisplayGroup;

public class SaveGroupMsg extends AwpMsg {
    public final DisplayGroup displayGroup;

    public SaveGroupMsg(DisplayGroup displayGroup) {
        this.displayGroup = displayGroup;
    }
}
