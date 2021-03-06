package com.example.sampleapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DataModel
{
    @SerializedName("title")
    private String title;
    @SerializedName("rows")
    private ArrayList<Rows> rows;

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public ArrayList<Rows> getRows ()
    {
        return rows;
    }

    public void setRows (ArrayList<Rows> rows)
    {
        this.rows = rows;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [title = "+title+", rows = "+rows+"]";
    }
}