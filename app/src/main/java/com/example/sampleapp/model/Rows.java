package com.example.sampleapp.model;

public class Rows
{
    private String imageHref;

    private String description;

    private String title;

    public String getImageHref ()
    {
        return imageHref;
    }

    public void setImageHref (String imageHref)
    {
        this.imageHref = imageHref;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [imageHref = "+imageHref+", description = "+description+", title = "+title+"]";
    }
}