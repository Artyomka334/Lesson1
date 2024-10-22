package ru.mirea.kachalov.data.room.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "mushrooms")
public class Mushroom {

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "edibility")
    private Boolean edibility;


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getEdibility() {
        return edibility;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEdibility(Boolean edibility) {
        this.edibility = edibility;
    }

}
