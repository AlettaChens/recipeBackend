package com.example.food.entity;

import java.util.List;

public class Talk {
    private Formu formu;
    private List<Image> imageList;

    public Talk(Formu formu, List<Image> imageList) {
        this.formu = formu;
        this.imageList = imageList;
    }

    public Formu getFormu() {
        return formu;
    }

    public void setFormu(Formu formu) {
        this.formu = formu;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }
}
