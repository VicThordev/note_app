package com.example.noteapp;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "note_table")
public class Note {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int priorityNumber;
    int id;
    String info;
    String category;
    String date;
    String time;

    public Note(String info, String category, String date, String time) {
        this.info = info;
        this.category = category;
        this.date = date;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getInfo() {
        return info;
    }

    public int getPriorityNumber() {
        return priorityNumber;
    }

    public void setPriorityNumber(int priorityNumber) {
        this.priorityNumber = priorityNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
   }

    public String getDate() {
        return date;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
