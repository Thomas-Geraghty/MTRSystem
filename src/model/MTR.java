package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MTR {

    private static MTR instance;
    private Graph graphOfStations = new Graph();
    private HashMap<String, Line> lineList = new HashMap<String, Line>();
    private HashMap<String, Station> stationList = new HashMap<String, Station>();

    /**
     * Singleton pattern. for class MTR
     */
    private MTR() {
    }

    /**
     * Part of singleton patten for class MTR. Returns single instance of MTR.
     * @return instance     Instance of MTR class that is constant.
     */
    public static MTR getInstance() {
        if (instance == null) {
            instance = new MTR();
        }
        return instance;
    }

    /**
     * Adds passed Line object to list of current lines in the system.
     * @param line      Line object to add.
     */
    public void addLine(Line line) {
        lineList.put(line.getLineName(), line);
    }

    /**
     * Returns all the Line objects in the MTR, in an ArrayList.
     * @return  ArrayList<Line>     ArrayList containing Line objects.
     */
    public HashMap<String, Line> getLines() {
        return lineList;
    }

    /**
     * Adds station to HashMap of stations, checks if duplicate station, and if so
     * does not create a new station entry, but instead merges original with duplicate..
     * Adds the station to the line it is on, too,
     * @param station       Station to add to system.
     */
    public void addStation(Station station) {
        stationList.put(station.getStationName(),station);
        graphOfStations.addNode(station);
    }

    /**
     * Returns all the Station objects in the MTR, in an ArrayList.
     * @return  ArrayList<Station>     ArrayList containing Station objects.
     */
    public HashMap<String, Station> getStations() {
        return stationList;
    }

    /**
     * Lists all connected lines to a Line.
     * @param lineName
     * @return 
     */
    public Set<Line> getConnectedLines(String lineName) {
        Line line = lineList.get(lineName);
        Set<Line> linkedLines = new HashSet<Line>();

        for(Station station : line.getStations()) {
            linkedLines.addAll(station.getLines());
        }
        linkedLines.remove(line);

        return linkedLines;
    }

    public Graph getGraph() {
        return graphOfStations;
    }
}
