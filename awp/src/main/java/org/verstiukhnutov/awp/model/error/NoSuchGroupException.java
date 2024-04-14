package org.verstiukhnutov.awp.model.error;

import java.util.NoSuchElementException;

public class NoSuchGroupException extends ModelProcessingException {
    public NoSuchGroupException(String groupName) {
        super("No such group `"+groupName+"`");
    }
}
