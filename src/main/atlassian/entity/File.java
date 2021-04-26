package main.atlassian.entity;

public class File {
    private String collectionId;
    private String file;
    private int size;

    public File(String collectionId, String file, int size) {
        this.collectionId = collectionId;
        this.file = file;
        this.size = size;
    }

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
