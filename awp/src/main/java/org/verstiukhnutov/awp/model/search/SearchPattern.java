package org.verstiukhnutov.awp.model.search;

import java.util.regex.Pattern;

import org.verstiukhnutov.awp.model.error.InvalidSearchPromptException;

public class SearchPattern {
    private static final Pattern SEARCH_PROMPT_REGEX = Pattern.compile("[,0-9A-Za-zА-Яа-яҐІЇЄґіїє\\-\\?\\* ]+");

    private Pattern regex;

    public SearchPattern(String regex) throws InvalidSearchPromptException {
        if (!SEARCH_PROMPT_REGEX.matcher(regex).matches())
            throw new InvalidSearchPromptException(regex);

        regex = regex.toLowerCase();
        regex = regex.replaceAll("\\?", "%").replaceAll("[\\*]+", "#");
        regex = regex.replaceAll("\\%", "[,0-9A-Za-zА-Яа-яҐІЇЄґіїє\\\\-\\\\?\\\\* ]");
        regex = regex.replaceAll("\\#", "[,0-9A-Za-zА-Яа-яҐІЇЄґіїє\\\\-\\\\?\\\\* ]*");
        System.out.println(regex);
        this.regex = Pattern.compile(regex);
    }

    public boolean pertains(String s) {
        return regex.matcher(s.toLowerCase()).find();
    }

    @Override
    public String toString() {
        return regex.toString();
    }
}
