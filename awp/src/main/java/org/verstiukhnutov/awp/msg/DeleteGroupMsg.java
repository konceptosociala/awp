package org.verstiukhnutov.awp.msg;

public class DeleteGroupMsg extends AwpMsg {
    public final String widgetName;

    public DeleteGroupMsg(String widgetName) {
        this.widgetName = widgetName;
    }
}
