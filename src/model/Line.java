package model;

import java.util.ArrayList;

public class Line {

    private final ArrayList<Station> STATIONS_IN_LINE = new ArrayList<Station>();
    private String lineName;



    public Line(String lineName) {
        this.lineName = lineName;
     }

    /**
     * Returns Line name.
     * @return lineName     String
     */
    public String getLineName() {
        return lineName;
    }

    /**
     * Adds station to line.
     * @param station
     */
    public void addStation(Station station) {
        STATIONS_IN_LINE.add(station);
    }

    /**
     * Returns all STATIONS_IN_LINE of line.
     * @return
     */
    public ArrayList<Station> getSTATIONS_IN_LINE() {
        return STATIONS_IN_LINE;
    }

    @Override
    public String toString() {
        return lineName;
    }
}
