package org.verstiukhnutov.awp.msg;

public class EditGroupMsg extends AwpMsg {
    public final String widgetName;

    public EditGroupMsg(String widgetName) {
        this.widgetName = widgetName;
    }
}
