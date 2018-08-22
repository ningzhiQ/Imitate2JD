package com.jd.myjd.imitate2jd.bean;

public class Mybean {
    private Integer image;
    private String name;

    public Mybean(Integer image, String name) {
        this.image = image;
        this.name = name;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Mybean{" +
                "image=" + image +
                ", name='" + name + '\'' +
                '}';
    }
}
