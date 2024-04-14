package org.verstiukhnutov.awp.msg;

import org.verstiukhnutov.awp.view.widgets.DisplayItem;

public class SaveProductMsg extends AwpMsg{
    private final DisplayItem displayItem;

    public SaveProductMsg(DisplayItem displayItem) {
        this.displayItem = displayItem;
    }

    public DisplayItem getDisplayItem() {
        return displayItem;
    }
}
