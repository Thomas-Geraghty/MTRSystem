package model;


import java.util.ArrayList;
import java.util.HashSet;

public class Station {

    private String stationName;
    private ArrayList<Line> lines = new ArrayList<Line>();
    private HashSet<Station> connectedStations = new HashSet<Station>();


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
    public ArrayList<Line> getLines() {
        return lines;
    }

    public void addConnectedStation(Station station) {
        connectedStations.add(station);
    }

    public HashSet<Station> getConnectedStations() {
        return connectedStations;
    }

    @Override
    public String toString() {
        return "" + stationName + " "+ getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
}
