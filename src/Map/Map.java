package Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Map {

    private static Map instance;
    private HashMap<String, Line> lineList = new HashMap<String, Line>();
    private HashMap<String, Station> stationList = new HashMap<String, Station>();

    /**
     * Singleton pattern. for class Map
     */
    private Map() {}

    /**
     * Part of singleton patten for class Map. Returns single instance of Map.
     * @return instance     Instance of Map class that is constant.
     */
    public static Map getInstance() {
        if (instance == null) {
            instance = new Map();
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

    /**
     * Returns array of Station objects representing the termini of passed Line.
     * The first element representing the first termini and the second element representing the final termini.
     * @param lineName      Name of line to get termini of.
     * @return  Station{[]         Array of Station objects representing termini.
     */
    public Station[] getTermini(String lineName) {
        Line line = lineList.get(lineName);
        Station[] termini = new Station[2];

        termini[0] = line.getStations().get(0);
        termini[1] = line.getStations().get(line.getStations().size() -1);

        return termini;
    }

    /**
     * Returns an ArrayList containing all the Station objects of the line.
     * @param lineName
     * @return
     */
    public ArrayList<Station> getStationsFromLine(String lineName) {
        Line line = lineList.get(lineName);
        return line.getStations();
    }

    public Set<Line> getConnectedLines(String lineName) {
        Line line = lineList.get(lineName);
        Set<Line> linkedLines = new HashSet<Line>();

        for(Station station : line.getStations()) {
            linkedLines.addAll(station.getLines());
        }
        return linkedLines;
    }

    /**
     * Returns all the Line objects in the Map, in an ArrayList.
     * @return  ArrayList<Line>     ArrayList containing Line objects.
     */
    public ArrayList<Line> getLineList() {
        ArrayList<Line> listOfLines= new ArrayList<Line>();
        listOfLines.addAll(lineList.values());
        return listOfLines;
    }

    /**
     * Returns all the Station objects in the Map, in an ArrayList.
     * @return  ArrayList<Station>     ArrayList containing Station objects.
     */
    public ArrayList<Station> getStations() {
        ArrayList<Station> listOfStations= new ArrayList<Station>();

        listOfStations.addAll(stationList.values());
            /**
            for(Line line : station.getLineList()){
                System.out.println("         "+ "• " + line);
            }
             **/
        return listOfStations;
    }
}
