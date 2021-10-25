import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileApi {
    public static void main(String[] args) {

        Path path1 = Paths.get(Utils.filePath1);
        System.out.println(path1);

        Path path2 = Path.of(Utils.filePath2);
        System.out.println(path2);

        boolean doesExist = Files.exists(path2);
        System.out.println(doesExist);

        try {
            System.out.println(Files.getLastModifiedTime(path2));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(Files.getOwner(path2));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Path tempDirectory = Files.createTempDirectory(Utils.fileName);
            Path tempFile = Files.createTempFile(Utils.fileName, Utils.fileSuffix);
            System.out.println(tempDirectory);
            System.out.println(tempFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Path tempFile = Files.createTempFile(Utils.fileName, Utils.fileSuffix);
            Files.writeString(tempFile, Utils.fileContent);
            System.out.println(tempFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Path tempFile = Files.createTempFile(Utils.fileName, Utils.fileSuffix);
            Files.write(tempFile, Utils.fileContent.getBytes(StandardCharsets.ISO_8859_1));
            System.out.println(tempFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Path tempFile = Files.createTempFile(Utils.fileName, Utils.fileSuffix);
            Files.writeString(tempFile, Utils.fileContent);
            String message = Files.readString(tempFile);

            System.out.println(tempFile);
            System.out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Path tempFile = Files.createTempFile(Utils.fileName, Utils.fileSuffix);
            Files.writeString(tempFile, Utils.fileContent);
            Files.delete(tempFile);
            System.out.println(Files.exists(tempFile));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
