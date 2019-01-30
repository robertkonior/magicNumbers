package app.validators.filevalidators;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextValidator implements FileValidator {

    @Override
    public boolean isValidExtension(String path) {
        char[] chars = readChars(path);
        return isValid(chars);
    }

    private static char[] readChars(String path) {
        char[] chars = new char[2000];
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            in.read(chars);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return chars;
    }

    private boolean isValid(char[] chars) {
        for (char ch : chars) {
            if (ch == 0) break;
            if (!(ch <= 126)) return false;
        }
        return true;
    }

}
