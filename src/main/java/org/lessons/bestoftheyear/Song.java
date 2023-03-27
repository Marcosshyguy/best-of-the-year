package org.lessons.bestoftheyear;

public class Song {
    private String title;
    private int id = 0;

    public Song(String title) {
        this.title = title;
        id = id++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

}
