package org.verstiukhnutov.awp.msg;

public class EditProductMsg extends AwpMsg {
    public final String widgetName;

    public EditProductMsg(String widgetName) {
        this.widgetName = widgetName;
    }
}
