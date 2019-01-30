package app.validators.filevalidators;

public class JpgValidator implements FileValidator {
    @Override
    public boolean isValidExtension(String path) {
        return false;
    }
}
