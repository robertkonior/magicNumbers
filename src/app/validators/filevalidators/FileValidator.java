package app.validators.filevalidators;

import java.util.Arrays;

public abstract class FileValidator {

    boolean validate(byte[] byteFromFile , byte[] magicNumber) {
       return Arrays.equals(byteFromFile, magicNumber);
    }
}
