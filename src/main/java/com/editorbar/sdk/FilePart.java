package com.editorbar.sdk;

public class FilePart {
    private String name;
    private String originalFilename;
    private String contentType;
    private byte[] file;

    public FilePart(String name, String originalFilename, String contentType, byte[] file) {
        this.name = name;
        this.originalFilename = originalFilename;
        this.contentType = contentType;
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginalFilename() {
        return originalFilename;
    }

    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
