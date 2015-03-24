import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListDuplicatingFiles {

    public static void main(String[] args) {
        ListDuplicatingFiles fw = new ListDuplicatingFiles();

        List<File> allFiles = new ArrayList<File>();
        //Please fill the path to Your test folder here
        String pathToDir = "W:\\_HackBulgaria\\JavaCoreV2.0\\TestFolderForListingFiles";

        try{
            allFiles.addAll(fw.browseDir(pathToDir));
            removeDuplicatedFilesFromList(allFiles);
            printFileNamesNoDuplicates(allFiles);
        } catch (NullPointerException ex) {
            System.out.println("There is no such directory.");
        }
    }

    private static void printFileNamesNoDuplicates(List<File> allFiles) {
        List<String> fileNamesToPrint = new ArrayList<String>();
        if (allFiles.size() == 0) {
            System.out.println("The directory is empty.");
        } else {
            for (int i = 0; i < allFiles.size(); i++) {
                fileNamesToPrint.add(allFiles.get(i).getName());
            }

            System.out.println(fileNamesToPrint);
        }
    }

    private static void removeDuplicatedFilesFromList(List<File> allFiles) {
        List<File> duplicateFiles = new ArrayList();
        for (int f1 = 0; f1 < allFiles.size() - 1; f1++) {
            for (int i = 1; i < allFiles.size() - f1; i++) {
                try{
                    Boolean areFilesEqual = FileUtils.contentEquals(allFiles.get(f1), allFiles.get(f1 + i));
                    if (areFilesEqual){
                        duplicateFiles.add(allFiles.get(f1));;
                    }
                } catch(IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

        allFiles.removeAll(duplicateFiles);
    }

    public List<File> browseDir(String path) {
        List<File> allFiles = new ArrayList<File>();
        List<File> result = browseDirRecursiveAndAddFilesToList(path, allFiles);
        return result;
    }

    private List<File> browseDirRecursiveAndAddFilesToList(String path, List<File> allFiles) {
        File root = new File(path);
        File[] list = root.listFiles();

        for ( File f : list ) {
            if ( f.isDirectory() ) {
                browseDirRecursiveAndAddFilesToList(f.getAbsolutePath(), allFiles);
            } else {
                allFiles.add(f);
            }
        }

        return allFiles;
    }
}
