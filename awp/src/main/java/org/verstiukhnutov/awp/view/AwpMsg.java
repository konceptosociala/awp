package org.verstiukhnutov.awp.view;

public class AwpMsg {
    private String msg = "";

    public AwpMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}