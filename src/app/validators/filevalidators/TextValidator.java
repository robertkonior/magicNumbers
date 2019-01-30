package app.validators.filevalidators;

public class TextValidator implements FileValidator {
    @Override
    public boolean isValidExtension(String path) {
        return false;
    }
}
