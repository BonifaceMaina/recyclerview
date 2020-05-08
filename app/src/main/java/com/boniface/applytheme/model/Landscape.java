package com.boniface.applytheme.model;

import com.boniface.applytheme.R;

import java.util.ArrayList;

public class Landscape {
    private int imageID;
    private String title;
    private String description;

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static ArrayList<Landscape> getData(){
        ArrayList<Landscape> dataList = new ArrayList<>();

        int [] images = getImages();

        for (int i=0; i< images.length; i++){
            Landscape landscape = new Landscape();
            landscape.setImageID(images[i]);
            landscape.setTitle("Landscape "+ i);

            dataList.add(landscape);
        }
        return dataList;
    }

    private static int[] getImages() {
        int [] images = {
                R.drawable.ani_cat_five, R.drawable.ani_cat_four, R.drawable.ani_cat_two, R.drawable.ani_cat_one,
                R.drawable.ani_cat_three, R.drawable.ani_cat_six, R.drawable.ani_cat_seven, R.drawable.ani_deer_one,
                R.drawable.ani_deer_two, R.drawable.ani_deer_three, R.drawable.bird_parrot_one,
                R.drawable.bird_parrot_two, R.drawable.bird_parrot_three, R.drawable.bird_parrot_four, R.drawable.bird_parrot_five,
                R.drawable.bird_parrot_six, R.drawable.bird_parrot_seven
        };
        return images;
    }
}
