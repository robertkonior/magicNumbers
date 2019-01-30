package app.validators;

import app.validators.filevalidators.FileValidator;
import app.validators.filevalidators.GifValidator;
import app.validators.filevalidators.JpgValidator;
import app.validators.filevalidators.TextValidator;

public class ValidatorFactory {

    public FileValidator getExtensionValidator(String extension) {
        switch (extension) {
            case "jpg" :
                return new JpgValidator();
            case "gif" :
                return new GifValidator();
            case "txt" :
                return new TextValidator();
        }
        return null;
    }

}
