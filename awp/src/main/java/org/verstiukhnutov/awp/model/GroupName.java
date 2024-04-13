package org.verstiukhnutov.awp.model;

import java.util.regex.Pattern;

import org.verstiukhnutov.awp.model.error.InvalidGroupNameException;

public class GroupName {
    private static final Pattern GROUP_NAME_REGEX = Pattern.compile("[A-ZАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯҐІЇЄ][a-zабвгдеёжзийклмнопрстуфхцчшщъыьэюяґіїє\\-]*[ A-ZАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯҐІЇЄa-zабвгдеёжзийклмнопрстуфхцчшщъыьэюяґіїє\\-]*");
    private String name;

    public GroupName(String name) throws InvalidGroupNameException {
        if (GROUP_NAME_REGEX.matcher(name).matches())
            this.name = name;
        else 
            throw new InvalidGroupNameException(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
