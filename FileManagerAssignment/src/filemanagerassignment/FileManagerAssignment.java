package filemanagerassignment;

import java.io.IOException;
import java.util.Scanner;

public class FileManagerAssignment {

    public static void main(String[] args) throws IOException {
        System.out.println("Enter operation: \nLIST\nINFO\nCREATE_DIR\nRENAME\nCOPY\nDELETE\nMOVE");
        
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        
        System.out.println(input);
        
        ListingOperations op = ListingOperations.valueOf(input);

        switch (op) {
            case LIST:
                Operations.listFolder(Operations.readInputPath("Enter folder path: "));
                break;
            case INFO:
                Operations.displayInfo(Operations.readInputPath("Enter path: "));
                break;
            case CREATE_DIR:
                Operations.createDir(Operations.readInputPath("Enter directory path: "));
                break;
            case RENAME:
                String oldPath = Operations.readInputPath("Enter old path: ");
                String newPath = Operations.readInputPath("Enter new path: ");
                Operations.rename(oldPath, newPath);
                break;
            case COPY:
                String oldP = Operations.readInputPath("Enter source path: ");
                String newP = Operations.readInputPath("Enter destination path: ");
                Operations.recursiveCopy(oldP, newP);
                System.out.println("Files were succesfully copied!");
                break;
            case DELETE:
                String path = Operations.readInputPath("Enter path: ");
                Operations.deleting(path);
                break;
            case MOVE:
                String srcPath = Operations.readInputPath("Enter source path: ");
                String destPath = Operations.readInputPath("Enter destination path: ");
                Operations.moving(srcPath, destPath);
                break;
            default:
                System.out.println("Invalid option!");
                break;

        }

    }
}
