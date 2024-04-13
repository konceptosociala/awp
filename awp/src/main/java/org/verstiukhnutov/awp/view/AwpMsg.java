package org.verstiukhnutov.awp.view;

public class AwpMsg {
    private String msg = "";
    private String additionalInfo = "";

    public AwpMsg(String msg) {
        this.msg = msg;
    }

    public AwpMsg(String msg, String additionalInfo) {
        this.msg = msg;
        this.additionalInfo = additionalInfo;
    }

    public String getMsg() {
        return msg;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    @Override
    public String toString() {
        return msg;
    }
}