package com.boniface.applytheme.model;

import com.boniface.applytheme.R;

import java.util.ArrayList;
import java.util.List;

public class NavigationDrawerItem {
    private String title;
    private int imageId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public static List<NavigationDrawerItem> getData(){
        List<NavigationDrawerItem> dataList = new ArrayList<>();
        int [] imageIds = getImages();
        String [] titles = getTitles();

        for(int i=0;i<titles.length; i++){
            NavigationDrawerItem navigationDrawerItem = new NavigationDrawerItem();
            navigationDrawerItem.setTitle(titles[i]);
            navigationDrawerItem.setImageId(imageIds[i]);
            dataList.add(navigationDrawerItem);
        }
        return dataList;
    }

    private static int [] getImages(){
        return new int[]{
                R.drawable.ic_add, R.drawable.ic_delete, R.drawable.ic_edit,
                R.drawable.bird_parrot_seven, R.drawable.bird_parrot_six, R.drawable.bird_parrot_five
        };
    }

    private static String [] getTitles(){
        return new String[] {
                "Add Stuff", "Delete Stuff", "Edit Stuff", "Item Four", "Item Five", "Item Six"
        };
    }
}
