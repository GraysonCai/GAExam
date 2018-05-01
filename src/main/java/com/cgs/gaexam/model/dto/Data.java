package com.cgs.gaexam.model.dto;

public class Data<T> {
    private String name;
    private T value;

    public Data() {
    }

    public Data(String name, T value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
