package org.verstiukhnutov.awp.model.error;

public class NoSuchGroupException extends ModelProcessingException {
    public NoSuchGroupException(String groupName) {
        super("No such group `"+groupName+"`");
    }
}
