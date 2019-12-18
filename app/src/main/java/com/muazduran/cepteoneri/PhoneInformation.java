package com.muazduran.cepteoneri;

import java.io.Serializable;

public class PhoneInformation implements Serializable {

    private String brandName;
    private String modelName;
    private int RAM;
    private int antutu;
    private int Camera;
    private String resolution;
    private double size;
    private int storage;
    private int battery;
    private String guaranty;
    //private String codeName;
    //private String Processor;

    //Constructor
    public PhoneInformation() {}
    /*public PhoneInformation(String brandName, String modelName, int RAM, int antutu, int camera, String resolution, double size, String storage, int battery, String guaranty) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.RAM = RAM;
        this.antutu = antutu;
        this.Camera = camera;
        this.resolution = resolution;
        this.size = size;
        this.storage = storage;
        this.battery = battery;
        this.guaranty = guaranty;
    }*/

    //Getters
    public String getBrandName() {return brandName;}
    public String getModelName(){return modelName;}
    public int getRAM(){return RAM;}
    public int getCamera(){return Camera;}
    public int getAntutu() {return antutu; }
    public int getStorage() {return storage;}
    public String getResolution(){return resolution;}
    public double getSize(){return size;}
    public int getBattery(){return battery;}
    public String getGuaranty(){return guaranty;}
    //public String getCodeName(){return codeName;}
    //public String getProcessor(){return Processor;}


    //Setters
    public void setBrandName(String brandName){this.brandName = brandName;}
    public void setModelName(String modelName){this.modelName = modelName;}
    public void setRAM(int RAM){this.RAM = RAM;}
    public void setCamera(int camera){Camera = camera;}
    public void setAntutu(int antutu) {this.antutu = antutu;}
    public void setStorage(int storage) {this.storage = storage;}
    public void setResolution(String resolution){this.resolution = resolution;}
    public void setSize(double size){this.size = size;}
    public void setBattery(int battery){this.battery = battery;}
    public void setGuaranty(String guaranty){this.guaranty = guaranty;}
    //public void setCodeName(String codeName){this.codeName = codeName;}
    //public void setProcessor(String processor) { Processor = processor; }
}
