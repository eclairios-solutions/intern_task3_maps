package com.miczon.task3_maps;

public class Model {

    private String address;
    private String id;

    public Model() {
    }

    public Model(String address, String id) {
        this.address = address;
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
