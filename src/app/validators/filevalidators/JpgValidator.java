package app.validators.filevalidators;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JpgValidator implements FileValidator {

    private List<byte[]> magicSignatures;

    public JpgValidator() {
        this.magicSignatures = getMagicSignatures();
    }

    @Override
    public boolean isValidExtension(String path) {
        List<byte[]> fileSignatures = new ArrayList<>();
        try {
            for (byte[] magicSignature : magicSignatures) {
                fileSignatures.add(new byte[magicSignature.length]);
            }

            for (int i = 0; i < fileSignatures.size(); i++) {
                FileInputStream inputStream = new FileInputStream(path);
                byte[] fileSignature = fileSignatures.get(i);
                int fileSignatureLength = inputStream.read(fileSignature);
                fileSignatures.set(i , fileSignature);
                if (fileSignatureLength < magicSignatures.get(i).length) return false;
            }

            for (int j = 0; j < magicSignatures.size(); j++) {
                if (Arrays.equals(magicSignatures.get(j),fileSignatures.get(j))) return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return false;
    }

    private List<byte[]> getMagicSignatures() {
        List<byte[]> signatures = new ArrayList<>();
        signatures.add(new byte[]{-1, -40, -1, -18});
        signatures.add(new byte[]{71, 73, 70, 56, 55, 97});
        signatures.add(new byte[]{-1, -40, -1, -32, 0, 16, 74, 70, 73, 70, 0, 1});

        return signatures;
    }
}
