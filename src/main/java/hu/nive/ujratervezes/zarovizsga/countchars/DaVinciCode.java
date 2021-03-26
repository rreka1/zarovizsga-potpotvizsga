package hu.nive.ujratervezes.zarovizsga.countchars;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DaVinciCode {

    public static final String CHARS = "01x";

    public int encode(String path, char c) {
        if (!CHARS.contains(Character.toString(c))) {
            throw new IllegalArgumentException("Only '0', '1', or 'x' are allowed to search!");
        }
        try {
            String str = Files.readString(Path.of(path));
            return countChars(str, c);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }
    }

    private int countChars(String s, char charToCount) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == charToCount) {
                count++;
            }
        }
        return count;
    }
}
