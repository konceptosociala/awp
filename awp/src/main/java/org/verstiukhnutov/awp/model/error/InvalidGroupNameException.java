package org.verstiukhnutov.awp.model.error;

public class InvalidGroupNameException extends ModelProcessingException {
    public InvalidGroupNameException(String groupName) {
        super("Invalid group name `"+groupName+"`: it must contain latin, cyrillic characters and minus (-); and must be Capitalized. For example `Електро-технічні товари`");
    }
}
