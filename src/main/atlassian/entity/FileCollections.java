package main.atlassian.entity;

import java.util.ArrayList;
import java.util.List;

public class FileCollections {
    private String collectionId;
    private List<File>files = new ArrayList<>();
    int totalSize;

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }
    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }
}

