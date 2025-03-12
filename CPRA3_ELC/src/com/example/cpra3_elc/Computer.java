package com.example.cpra3_elc;

import java.io.Serializable;

public class Computer implements Serializable {
    private String brand;
    private String model;
    private String processor;
    private String ram;
    private String storage;
    private int imageId;

    public Computer(String brand, String model, String processor, String ram, String storage, int imageId) {
        this.brand = brand;
        this.model = model;
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.imageId = imageId;
    }

    // Getters
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public String getProcessor() { return processor; }
    public String getRam() { return ram; }
    public String getStorage() { return storage; }
    public int getImageId() { return imageId; }

    // Setters
    public void setBrand(String brand) { this.brand = brand; }
    public void setModel(String model) { this.model = model; }
    public void setProcessor(String processor) { this.processor = processor; }
    public void setRam(String ram) { this.ram = ram; }
    public void setStorage(String storage) { this.storage = storage; }
    public void setImageId(int imageId) { this.imageId = imageId; }

    @Override
    public String toString() {
        return brand + " " + model;
    }
}
