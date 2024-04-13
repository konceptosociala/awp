package org.verstiukhnutov.awp.model;

import java.util.regex.Pattern;

import org.verstiukhnutov.awp.model.error.InvalidProductNameException;

public class ProductName {
    private static final Pattern PRODUCT_NAME_REGEX = Pattern.compile("[A-ZА-ЯҐІЇЄ][ ,A-ZА-ЯҐІЇЄa-zа-яґіїє0-9\\-]*");
    private String name;

    public ProductName(String name) throws InvalidProductNameException {
        if (PRODUCT_NAME_REGEX.matcher(name).matches())
            this.name = name;
        else 
            throw new InvalidProductNameException(name);
    }

    @Override
    public String toString() {
        return name;
    }
}