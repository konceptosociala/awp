package org.verstiukhnutov.awp.model.error;

public class InvalidProductNameException extends ModelProcessingException {
    public InvalidProductNameException(String productName) {
        super("Invalid product name `"+productName+"`: it must contain latin, cyrillic characters, numbers (0-9), comma (,) and minus (-); and must be Capitalized. For example: `Молоко Mleczna Dolina 3,2 в коробці`");
    }
}
