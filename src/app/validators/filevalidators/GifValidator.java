package app.validators.filevalidators;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GifValidator implements FileValidator {

    private List<byte[]> magicSignatures;

    public GifValidator() {
        this.magicSignatures = getMagicSignatures();
    }

    @Override
    public boolean isValidExtension(String path) {
        int magicSignatureLength = magicSignatures.get(1).length;
        byte[] fileSignature = new byte[magicSignatureLength];
        try (FileInputStream inputStream = new FileInputStream(path)) {
            int fileSignatureLength = inputStream.read(fileSignature);
            if (fileSignatureLength < magicSignatureLength) return false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (byte[] signature : magicSignatures) {
            if (Arrays.equals(signature, fileSignature)) return true;
        }
        return false;
    }

    private List<byte[]> getMagicSignatures() {
        List<byte[]> signatures = new ArrayList<>();
        signatures.add(new byte[]{-1, -40, -1, -37});
        signatures.add(new byte[]{71, 73, 70, 56, 57, 97});
        return signatures;
    }
}
