package app.validators;

import app.exception.NotSupportedException;
import app.validators.filevalidators.FileValidator;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    private String path;
    private List<String> listSupportedExtensions;
    private static final String NOT_SUPPORTED = "Not supported this extension, sorry.";
    private static final String NOT_RECOGNIZED= "Extension assigned to the file is unrecognizable";
    private static final String CORRECT_EXT = "This signed extension is correct";

    public Validator(String path) {
        this.path = path;
        this.listSupportedExtensions = getListSupportedExtensions();
    }

    public void isValid() {
        String extension = getExtension(path);
        if (isValidExtensions()) {
            FileValidator fileValidator = ValidatorFactory.getExtensionValidator(extension);
            if (fileValidator != null && fileValidator.isValidExtension(path)) {
                System.out.println(CORRECT_EXT);
                return ;
            }
            findOtherExtension(extension);
        }
    }

    private void findOtherExtension(String ext) {
        List<String> listOfOtherExtensions = listSupportedExtensions;
        listOfOtherExtensions.remove(ext);
        for (String predictedExtension : listOfOtherExtensions) {
            FileValidator fileValidator = ValidatorFactory.getExtensionValidator(predictedExtension);
            if (fileValidator.isValidExtension(path)) {
                System.out.println
                        ("This is " + predictedExtension + " while currently is signed as  " + ext);
                return;
            }
        }
        System.out.println(NOT_RECOGNIZED);
    }

    private boolean isValidExtensions() {
        String extensions = getExtension(path);
        if (listSupportedExtensions.contains(extensions)) return true;
        throw new NotSupportedException(NOT_SUPPORTED);
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
