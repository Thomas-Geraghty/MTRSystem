package model;


import java.util.ArrayList;
import java.util.HashSet;

public class Station extends Node {

    private String stationName;
    private HashSet<Line> lines = new HashSet<Line>();


    public Station(String stationName) {
        this.stationName = stationName;
    }

    /**
     * Returns name of station.
     * @return
     */
    public String getStationName() {
        return stationName;
    }

    /**
     * Adds station to a line.
     * @param line
     */
    public void addLine(Line line) {
        lines.add(line);
    }

    /**
     * Returns arraylist containing what Lines station is part of.
     * @return
     */
    public HashSet<Line> getLines() {
        return lines;
    }

    @Override
    public String toString() {
        return "" + stationName + getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
}
