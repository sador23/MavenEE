package com.misc;

/**
 * Created by sador on 02.03.17.
 */
public class Story {

    public String title;
    public String story;
    public String status;
    public String criteria;
    public int value;
    public float estimation;
    public int id;

    public Story(int id,String title, String story, String criteria, String status, int value, float estimation){
        this.title=title;
        this.status=status;
        this.story=story;
        this.criteria=criteria;
        this.value=value;
        this.estimation=estimation;
        this.id=id;
    }

    public String getTitle() {
        return title;
    }

    public String getStory() {
        return story;
    }

    public String getStatus() {
        return status;
    }

    public String getCriteria() {
        return criteria;
    }

    public int getValue() {
        return value;
    }

    public float getEstimation() {
        return estimation;
    }

    public int getId() {
        return id;
    }
}
