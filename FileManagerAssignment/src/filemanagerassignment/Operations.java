package filemanagerassignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Operations {

    public static String readInputPath(String userMessage) {
        System.out.println(userMessage);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static void listFolder(String folderPath) {
        File file = new File(folderPath);
        if (file.exists() && file.isDirectory()) {
            String[] files = file.list();

            for (int i = 0; i < files.length; i++) {
                System.out.println(files[i]);
            }
        } else {
            System.out.println("Invalid path!");
        }
    }

    public static void displayInfo(String path) {
        File file = new File(path);

        if (file.exists()) {
            System.out.println("Name is: " + file.getName());
            System.out.println("Path is: " + file.getAbsolutePath());
            System.out.println("Length is: " + file.length());

            Instant instant = Instant.ofEpochMilli(file.lastModified());
            LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss");

            System.out.println("Last modified is: " + dateTime.format(dateTimeFormatter));
        }
    }

    public static void createDir(String dirPath) {
        File folder = new File(dirPath);
        try {
            if (!folder.exists()) {
                folder.mkdir();
                System.out.println("The new directory was created!");
            } else {
                System.out.println("Directory called: " + folder.getName() + " already exists!");
            }
        } catch (Exception exc) {
            System.out.println("The directory: " + folder.getName() + " was not created. Error: " + exc.getMessage());
        }
    }

    public static void rename(String oldPath, String newPath) {
        File oldFile = new File(oldPath);
        File newFile = new File(newPath);

        if (!oldFile.exists()) {
            System.out.println("File doesn't exist!");
            return;
        }
        if (newFile.exists()) {
            System.out.println("File with desired name exists!");
            return;
        }
        boolean result = oldFile.renameTo(newFile);
        if (result) {
            System.out.println("Rename was successful!");
        } else {
            System.out.println("Rename failed!");
        }
    }

    public static void recursiveCopy(String sourcePath, String destPath) {
        File fSource = new File(sourcePath);
        File fDest = new File(destPath);

        try {
            if (fSource.isDirectory()) {

                if (!fDest.exists()) {
                    fDest.mkdirs();
                }

                String[] fList = fSource.list();

                for (int index = 0; index < fList.length; index++) {
                    File dest = new File(fDest.getAbsolutePath(), fList[index]);
                    File source = new File(fSource.getAbsolutePath(), fList[index]);

                    recursiveCopy(source.getAbsolutePath(), dest.getAbsolutePath());
                }

            } else {

                FileInputStream fInStream = new FileInputStream(fSource);
                FileOutputStream fOutStream = new FileOutputStream(fDest);

                byte[] buffer = new byte[1024];
                int iBytesReads;

                while ((iBytesReads = fInStream.read(buffer)) > 0) {
                    fOutStream.write(buffer, 0, iBytesReads);
                }

                if (fInStream != null) {
                    fInStream.close();
                }

                if (fOutStream != null) {
                    fOutStream.close();
                }
            }
        } catch (Throwable ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }

    public static void deleting(String path) throws IOException {

        File folder = new File(path);
        if (folder.isDirectory()) {
            File[] entries = folder.listFiles();
            if (entries != null) {
                for (File entry : entries) {
                    deleting(entry.getAbsolutePath());
                    System.out.println("Deleted!");
                }
            }
        }
        if (!folder.delete()) {
            throw new IOException("Failed to delete: " + folder);
        }
    }

    public static void moving(String srcPath, String destPath) {
        File source = new File(srcPath);
        File destination = new File(destPath);

        try {
            recursiveCopy(source.getAbsolutePath(), destination.getAbsolutePath());
            deleting(source.getAbsolutePath());

            System.out.println("File was succesfully moved!");
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }
}
