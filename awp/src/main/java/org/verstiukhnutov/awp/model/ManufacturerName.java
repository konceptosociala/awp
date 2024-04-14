package org.verstiukhnutov.awp.model;

import java.util.regex.Pattern;
import org.verstiukhnutov.awp.model.error.InvalidManufacturerNameException;

public class ManufacturerName {
    public static final Pattern MANUFACTURER_NAME_REGEX = Pattern.compile("[A-ZА-ЯҐІЇЄa-zа-яґіїє][ A-ZА-ЯҐІЇЄa-zа-яґіїє\\-]*");
    private String name;

    public ManufacturerName(String name) throws InvalidManufacturerNameException {
        if (MANUFACTURER_NAME_REGEX.matcher(name).matches())
            this.name = name.toUpperCase();
        else 
            throw new InvalidManufacturerNameException(name);
    }

    @Override
    public String toString() {
        return "\"" + name + "\"";
    }
}