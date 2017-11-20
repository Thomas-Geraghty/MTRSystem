package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MTR {

    private static MTR instance;
    private HashMap<String, Line> lineList = new HashMap<String, Line>();
    private HashMap<String, Station> stationList = new HashMap<String, Station>();

    /**
     * Singleton pattern. for class MTR
     */
    private MTR() {}

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
        String lineName = line.getLineName();
        lineList.put(lineName, line);
    }

    /**
     * Adds station to HashMap of stations, checks if duplicate station, and if so
     * does not create a new station entry, but instead merges original with duplicate..
     * Adds the station to the line it is on, too,
     * @param station       Station to add to system.
     */
    public void addStation(Station station) {
        String stationName = station.getStationName();
        Line line = station.getLines().get(0);

        if(stationList.get(stationName) != null) {

            stationList.get(stationName).addLine(line);
            line.addStation(stationList.get(stationName));
        } else {

            stationList.put(stationName, station);
            line.addStation(station);
        }
    }

    public void connectStations() {
        for(Line line : lineList.values()) {
            for(int i = 0; i < line.getStations().size(); i++) {
                if(i > 0) {
                    line.getStations().get(i).addConnectedStation(line.getStations().get(i -1));
                }
            }
        }
    }

    /**
     * Returns array of Station objects representing the termini of passed Line.
     * The first element representing the first termini and the second element representing the final termini.
     * @param lineName      Name of line to get termini of.
     * @return  Station{[]         Array of Station objects representing termini.
     */

    /**
     * Returns an ArrayList containing all the Station objects of the line.
     * @param lineName
     * @return
     */
    public ArrayList<Station> getStationsFromLine(String lineName) {
        Line line = lineList.get(lineName);
        return line.getStations();
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

    /**
     * Returns all the Line objects in the MTR, in an ArrayList.
     * @return  ArrayList<Line>     ArrayList containing Line objects.
     */
    public HashMap<String, Line> getLineList() {
        return lineList;
    }

    /**
     * Returns all the Station objects in the MTR, in an ArrayList.
     * @return  ArrayList<Station>     ArrayList containing Station objects.
     */
    public ArrayList<Station> getStations() {
        ArrayList<Station> listOfStations= new ArrayList<Station>();

        listOfStations.addAll(stationList.values());
        return listOfStations;
    }
}
