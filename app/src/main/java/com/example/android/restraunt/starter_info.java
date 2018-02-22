package com.example.android.restraunt;


public class starter_info {


    int price;
    boolean selected = false;
    int imgid = R.drawable.app_1;
    String name = null;


    String item = null;

    public starter_info(int imgid, boolean selected, int price, String item) {
        super();
        this.price = price;
        this.selected = selected;
        this.imgid = imgid;
        this.item = item;
    }


    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}

