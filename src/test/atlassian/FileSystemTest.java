package test.atlassian;

import main.atlassian.FilesSystem;
import main.atlassian.entity.File;

import java.util.ArrayList;
import java.util.List;

public class FileSystemTest {

    FilesSystem fileSystem = new FilesSystem();

    List<File> file = new ArrayList<>();

    public void setUp() {
        File file1 = new File("", "file1.txt", 100);

        File file2 = new File("collection1", "file1.txt", 200);
        File file3 = new File("collection1", "file1.txt", 200);
        File file4 = new File("collection2", "file1.txt", 300);
        File file5 = new File("", "file5.txt", 10);

        file.add(file1);
        file.add(file2);
        file.add(file3);
        file.add(file4);
        file.add(file5);

    }

    /*
        Test FileSizeShould be Zero in empty fileSyste
     */
    public void getTotalFileSizeTestSizeZero() {
        if (fileSystem.getTotalFileSize() == 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    /*
           Test FileSizeShould be  Non Zero in empty fileSyste
        */
    public void getTotalFileSizeTestSizeNonZero() {

        fileSystem.storeFile(file.get(0));

        if (fileSystem.getTotalFileSize() == file.get(0).getSize()) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

     /*
        Test store File  be Zero in empty fileSyste
     */

    public void storeFileTest() {
        fileSystem.storeFile(file.get(0));
    }


     /*
        top N collections
     */

//
//    public voidgetTopNCollections(int N) throws Exception {
//
//    }
//
//
// /*
//        Test store File  be Zero in empty fileSyste
//     */
//
//
//    public void getTopNCollections(int N) throws Exception {
//
//    }


}
