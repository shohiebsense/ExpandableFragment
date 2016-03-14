package com.shohiebsense.expandablefragment;

/**
 * Created by Shohieb on 3/14/2016.
 */
public class History {

    private int id_history;

   /* @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private String id_title;*/

    public String id_title;

    public String period;

    public String description;


    public String description_en;

    public int bookmark;

    //needed
    public History() {

    }

    public History(int id_history, String id_title, String description, String period) {
        this.id_history = id_history;
        this.id_title = id_title;
        this.description = description;
        this.period = period;
    }

    public int getId_history() {
        return id_history;
    }




    public int getBookmark() {
        return bookmark;
    }

    public void setBookmark(int bookmark) {
        this.bookmark = bookmark;
    }

    public String getId_title() {
        return this.id_title;
    }

    public String getDescription() {
        return description;
    }

    public String getPeriod() {
        return this.period;
    }
}