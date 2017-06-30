package com.hhs.everyday;

import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hecto on 30/06/2017.
 */
public class TrackerManager {

    private void TrackerManager()
    {}

    public List<TrackerItem> getTrackersFromXML(InputStream inputStream ) {

        List<TrackerItem> trackersList = new ArrayList<TrackerItem>();
        InputSource inputSource = new InputSource(inputStream);
        XMLParser xml = new XMLParser(inputSource);
        trackersList = xml.readXml();

        return trackersList;
    }
}
