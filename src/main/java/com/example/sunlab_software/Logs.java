package com.example.sunlab_software;

import java.util.Formatter;

public class Logs {
    public String id;
    public String name;
    public String job;
    public String date;
    public String time;


    public Logs(String id, String name, String job, String date, String time){
        this.id = id;
        this.name = name;
        this.job = job;
        this.date = date;
        this.time = time;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getJob() {
        return job;
    }

    public String getTime() {
        return time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
