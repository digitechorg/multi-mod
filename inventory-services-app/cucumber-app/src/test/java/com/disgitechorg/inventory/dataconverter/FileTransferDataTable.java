package com.disgitechorg.inventory.dataconverter;

public class FileTransferDataTable {

    private final String fileSourceLocation;
    private final String fileTargetLocation;
    private final boolean dontSentFile;

    public FileTransferDataTable(String fileSourceLocation, String fileTargetLocation, boolean dontSentFile) {
        this.fileSourceLocation = fileSourceLocation;
        this.fileTargetLocation = fileTargetLocation;
        this.dontSentFile = dontSentFile;
    }

    public String getFileSourceLocation() {
        return fileSourceLocation;
    }

    public String getFileTargetLocation() {
        return fileTargetLocation;
    }

    public boolean isDontSentFile() {
        return dontSentFile;
    }
}
