package org.verstiukhnutov.awp.msg;

import org.verstiukhnutov.awp.model.Group;

public class OpenGroupMsg extends AwpMsg {
    private Group group;

    public OpenGroupMsg(Group group) {
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }
}
