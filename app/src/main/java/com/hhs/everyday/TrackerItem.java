package com.hhs.everyday;

/**
 * Created by Hecto on 27/05/2017.
 */
public class TrackerItem {
    private String name;
    private TrackerTypes type;

    public TrackerItem (String name, TrackerTypes type)
    {
        this.name = name;
        this.type = type;
    }



    public String getName()
    {
        return this.name;
    }

    public TrackerTypes getType()
    {
        return this.type;
    }
}
