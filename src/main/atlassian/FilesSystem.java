package main.atlassian;

import main.atlassian.entity.File;
import main.atlassian.entity.FileCollections;

import java.util.*;


//   - The total size of all files stored; and
//
//- The top N collections (by file size) where N can be a user-defined value
//            [
//[
//    {file: "file1.txt", size: 100},
//    {file: "file2.txt", size: 200, collectionId: "collection1"},
//    {file: "file3.txt", size: 200, collectionId: "collection1"},
//    {file: "file4.txt", size: 300, collectionId: "collection2"},
//    {file: "file5.txt", size: 10}
//]

public class FilesSystem {


    int totalFileSize = 0;

    private final static String DEFAULT_COLLECTION_ID = "DEFAULT";

    // Map <FileCollections, CollectionId>
    Map<FileCollections, String> collectionMap = new TreeMap<>(new FileSizeComparator());


    public int getTotalFileSize() {
        return totalFileSize;
    }

    public boolean storeFile(File file) {

        if (file == null || file.getSize() == 0) return false;
        if (file.getCollectionId() == null || file.getCollectionId().length() == 0) {
            file.setCollectionId(DEFAULT_COLLECTION_ID);
        }
        boolean isPresent = false;


        for (Map.Entry<FileCollections, String> entry : collectionMap.entrySet()) {
            if (entry.getKey().equals(file.getCollectionId())) {
                FileCollections fileCollection = entry.getKey();
                fileCollection.setTotalSize(fileCollection.getTotalSize() + file.getSize());
                fileCollection.getFiles().add(file);
                fileCollection.setCollectionId(file.getCollectionId());
                collectionMap.put(fileCollection, fileCollection.getCollectionId());
                isPresent = true;
            }
        }

        if (!isPresent) {
            FileCollections fileCollection = new FileCollections();
            fileCollection.setTotalSize(file.getSize());
            fileCollection.getFiles().add(file);
            fileCollection.setCollectionId(file.getCollectionId());
            collectionMap.put(fileCollection, fileCollection.getCollectionId());
        }


        totalFileSize = totalFileSize + file.getSize();

        return false;

    }

    public List<String> getTopNCollections(int N) throws Exception {

        List<String> collectionsIds = new ArrayList<>();
        if (N == 0) return collectionsIds;
        if (N > collectionMap.size()) throw new Exception(" Not Enogh Collections ");

        int count = 0;

        for (Map.Entry<FileCollections, String> entry : collectionMap.entrySet()) {
            if (count <= N) {
                if (!entry.getKey().getCollectionId().equals(DEFAULT_COLLECTION_ID))
                    collectionsIds.add(entry.getValue());
            } else break;
        }
        return collectionsIds;
    }

    class FileSizeComparator implements Comparator<FileCollections> {
        public int compare(FileCollections col1, FileCollections col2) {
            return col1.getTotalSize() - col2.getTotalSize();
        }
    }

    public static void main(String[] args) {

        File file1 = new File("", "file1.txt", 100);

        File file2 = new File("collection1", "file1.txt", 200);
        File file3 = new File("collection1", "file1.txt", 200);
        File file4 = new File("collection2", "file1.txt", 300);
        File file5 = new File("", "file5.txt", 10);

        FilesSystem fileSystem = new FilesSystem();

        fileSystem.storeFile(file1);
        fileSystem.storeFile(file2);
        fileSystem.storeFile(file3);
        fileSystem.storeFile(file4);
        fileSystem.storeFile(file5);


        try {
            System.out.println(fileSystem.getTotalFileSize());

            System.out.println(fileSystem.getTopNCollections(2));
        } catch (Exception ex) {

        }

    }

}
