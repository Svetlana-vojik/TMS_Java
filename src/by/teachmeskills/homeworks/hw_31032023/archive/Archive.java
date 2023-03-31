package by.teachmeskills.homeworks.hw_31032023.archive;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Archive {
    public static final String FILE_PATH1 = "C:\\Users\\svetlana.ezheleva\\Desktop\\data\\file1.txt";
    public static final String FILE_PATH2 = "C:\\Users\\svetlana.ezheleva\\Desktop\\data\\file2.txt";
    public static final String FILE_PATH3 = "C:\\Users\\svetlana.ezheleva\\Desktop\\data\\file3.txt";
    public static final String FILE_NAME1 = "file1.txt";
    public static final String FILE_NAME2 = "file2.txt";
    public static final String FILE_NAME3 = "file3.txt";
    public static final String ARCHIVE_PATH = "C:\\Users\\svetlana.ezheleva\\Desktop\\data\\output.zip";

    public static void main(String[] args) {
        File dir = new File("C:\\Users\\svetlana.ezheleva\\Desktop\\data");

        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(ARCHIVE_PATH));
             FileInputStream fis1 = new FileInputStream(FILE_PATH1);
             FileInputStream fis2 = new FileInputStream(FILE_PATH2);
             FileInputStream fis3 = new FileInputStream(FILE_PATH3)) {
            ZipEntry entry1 = new ZipEntry(FILE_NAME1);
            ZipEntry entry2 = new ZipEntry(FILE_NAME2);
            ZipEntry entry3 = new ZipEntry(FILE_NAME3);

            zout.putNextEntry(entry1);
            byte[] buffer = new byte[1000];
            fis1.read(buffer);
            zout.write(buffer);
            zout.closeEntry();

            zout.putNextEntry(entry2);
            fis2.read(buffer);
            zout.write(buffer);
            zout.closeEntry();

            zout.putNextEntry(entry3);
            fis3.read(buffer);
            zout.write(buffer);
            zout.closeEntry();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File newDir = new File("C:\\Users\\svetlana.ezheleva\\Desktop\\newdata");
        dir.renameTo(newDir);

        if (newDir.isDirectory()) {
            for (File file : Objects.requireNonNull(newDir.listFiles())) {
                if (file.isFile()) {
                    System.out.println(file.getName() + " файл");
                } else {
                    System.out.println(file.getName() + " каталог");
                }
            }
        }
        newDir.delete();
    }
}