package org.verstiukhnutov.awp.msg;

public class DeleteProductMsg extends AwpMsg {
    public final String widgetName;

    public DeleteProductMsg(String widgetName) {
        this.widgetName = widgetName;
    }
}
