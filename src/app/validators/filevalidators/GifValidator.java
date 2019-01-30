package app.validators.filevalidators;

import java.util.HashSet;
import java.util.Set;

public class GifValidator extends FileValidator{

    private Set<byte[]> singatures ;

    public GifValidator() {
        this.singatures = getSingatures();
    }

    @Override
    public boolean isValidExtension(String path) {
        return false;
    }

    private Set<byte[]> getSingatures() {
        Set<byte[]> singatures = new HashSet<>();
        singatures.add(new byte[]{71, 73, 70, 56, 55, 97});
        singatures.add(new byte[]{71, 73, 70, 56, 57, 97});
    }
}
