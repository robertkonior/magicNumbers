package app.validators;

import app.exception.NotSupportedException;
import app.validators.filevalidators.FileValidator;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    private String path;
    private List<String> listSupportedExtensions;
    private FileValidator fileValidator;

    public Validator(String path) {
        this.path = path;
        this.listSupportedExtensions = getListSupportedExtensions();
    }

    public boolean isValid(){

        if (isValidExtensions()) {
            FileValidator fileValidator = ValidatorFactory.getExtensionValidator(getExtension(path));
            if (fileValidator != null && fileValidator.isValidExtension(path)) {

            }
        }

        return false;
    }

    private boolean isValidExtensions() {
        String extensions = getExtension(path);
        if (listSupportedExtensions.contains(extensions)) return true;
        throw new NotSupportedException("not supported exception");
    }


    private String getExtension(String path) {
        return path.substring(path.lastIndexOf(".") + 1).toLowerCase();
    }

    private List<String> getListSupportedExtensions() {
        List<String> listSupportedExtensions = new ArrayList<>();
        listSupportedExtensions.add("jpg");
        listSupportedExtensions.add("jpeg");
        listSupportedExtensions.add("gif");
        listSupportedExtensions.add("txt");
        return listSupportedExtensions;
    }
}
