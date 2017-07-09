package com.hhs.everyday;

/**
 * Created by Hecto on 28/05/2017.
 */
public enum TrackerType {
    text,
    number,
    counter,
    spectrum,
    checkbox;

    public static String[] getStringValues() {
        String[] types = new String[TrackerType.values().length];
        int i =0;

        for  (TrackerType t: TrackerType.values()) {
            types[i++] = t.toString();
        }

        return types;
    }
}
