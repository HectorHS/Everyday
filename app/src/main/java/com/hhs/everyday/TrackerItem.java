package com.hhs.everyday;

/**
 * Created by Hecto on 27/05/2017.
 */
public class TrackerItem {
    private String name;
    private TrackerType type;

    public TrackerItem (String name, TrackerType type)
    {
        this.name = name;
        this.type = type;
    }

    public String getName()
    {
        return this.name;
    }

    public TrackerType getType() { return this.type; }
}
