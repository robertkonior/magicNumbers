package app.validators.filevalidators;

public class TextValidator extends FileValidator {
    @Override
    public boolean isValidExtension(String path) {
        return false;
    }
}
