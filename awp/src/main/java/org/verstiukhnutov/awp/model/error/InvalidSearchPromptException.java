package org.verstiukhnutov.awp.model.error;

public class InvalidSearchPromptException extends ModelProcessingException {
    public InvalidSearchPromptException(String prompt) {
        super("Invalid search prompt `"+prompt+"`: it must contain latin, cyrillic characters, numbers, filter characters (? and *) and minus (-)");
    }
}
