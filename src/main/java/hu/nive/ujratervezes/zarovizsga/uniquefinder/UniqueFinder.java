package hu.nive.ujratervezes.zarovizsga.uniquefinder;

import java.util.ArrayList;
import java.util.List;

public class UniqueFinder {

    public List<Character> uniqueChars(String s) {
        if (s == null) {
            throw new IllegalArgumentException("String input cannot be null!");
        }
        List<Character> result = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (!result.contains(c)) {
                result.add(c);
            }
        }
        return result;
    }
}
