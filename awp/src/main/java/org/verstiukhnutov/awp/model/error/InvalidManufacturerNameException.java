package org.verstiukhnutov.awp.model.error;

public class InvalidManufacturerNameException extends ModelProcessingException {
    public InvalidManufacturerNameException(String name) {
        super("Invalid manufacturer name `"+name+"`: it must contain latin, cyrillic characters and minus (-). For example `Києво-Могилянська Академія`");
    }
}
