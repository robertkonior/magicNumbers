package app.Validators;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    private String path;
    private List<String> listSupportedExtensions;

    public Validator(String path) {
        this.path = path;
        this.listSupportedExtensions = getListSupportedExtensions();
    }

    public boolean isValidExtensions() {
        String extensions = getExtension(path);
        if (listSupportedExtensions.contains(extensions)) return true;
        System.out.println("not supported extension");
        return false;
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
