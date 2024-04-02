package org.verstiukhnutov.awp.view;

public class AwpMsg {
    String msg = "";

    public AwpMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}