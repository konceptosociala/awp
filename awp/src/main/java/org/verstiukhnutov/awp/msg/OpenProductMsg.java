package org.verstiukhnutov.awp.msg;

public class OpenProductMsg extends AwpMsg {
    public final String widgetName;

    public OpenProductMsg(String widgetName) {
        this.widgetName = widgetName;
    }
}
