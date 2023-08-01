package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        List<String> result = new ArrayList<>();
        int lastIndex = 0;

        for (int i = 0; i < source.length(); i++) {
            for (String delimiter : delimiters) {
                int delimiterLength = delimiter.length();
                if (i + delimiterLength <= source.length() && source.substring(i, i + delimiterLength).equals(delimiter)) {
                    if (i != lastIndex) {
                        result.add(source.substring(lastIndex, i));
                    }
                    lastIndex = i + delimiterLength;
                    i += delimiterLength - 1;
                    break;
                }
            }
        }

        if (lastIndex < source.length()) {
            result.add(source.substring(lastIndex));
        }

        return result;
    }
}
