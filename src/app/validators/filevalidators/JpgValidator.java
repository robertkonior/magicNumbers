package app.validators.filevalidators;

public class JpgValidator extends FileValidator {
    @Override
    public boolean isValidExtension(String path) {
        return false;
    }
}
