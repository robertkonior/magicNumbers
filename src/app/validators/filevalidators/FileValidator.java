package app.validators.filevalidators;

import java.util.Arrays;

public abstract class FileValidator {

    public abstract boolean isValidExtension(String path);

    boolean validate(byte[] byteFromFile , byte[] magicNumber) {
       return Arrays.equals(byteFromFile, magicNumber);
    }
}
