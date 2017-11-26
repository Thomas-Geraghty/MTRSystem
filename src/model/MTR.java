package model;


import java.util.HashMap;

public class MTR {

    private static final HashMap<String, Line> LIST_OF_LINES = new HashMap<String, Line>();
    private static final HashMap<String, Station> LIST_OF_STATIONS = new HashMap<String, Station>();
    private static MTR INSTANCE;

    /**
     * Part of singleton patten for class MTR. Returns single INSTANCE of MTR.
     * @return INSTANCE     Instance of MTR class that is constant.
     */
    public static MTR getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MTR();
        }
        return INSTANCE;
    }

    /**
     * Adds passed Line object to list of current lines in the system.
     * @param line      Line object to add.
     */
    public void addLine(Line line) {
        LIST_OF_LINES.put(line.getLineName(), line);
    }

    /**
     * Returns the corresponding Line object from a line's name which is passed.
     * @param lineName
     * @return
     */
    public Line getLine(String lineName) {
        try {
            if(LIST_OF_LINES.containsKey(lineName)) {
                return LIST_OF_LINES.get(lineName);
            } else {
                throw new NullPointerException("No such Line with that name.");
            }
        } catch (NullPointerException ex){
            return null;
        }
    }

    /**
     * Returns all the Line objects in the MTR, in an ArrayList.
     * @return  ArrayList<Line>     ArrayList containing Line objects.
     */
    public HashMap<String, Line> getLines() {
        return LIST_OF_LINES;
    }

    /**
     * Adds station to HashMap of stations, checks if duplicate station, and if so
     * does not create a new station entry, but instead merges original with duplicate..
     * Adds the station to the line it is on, too,
     * @param station       Station to add to system.
     */
    public void addStation(Station station) {
        LIST_OF_STATIONS.put(station.getStationName(),station);
    }

    /**
     * Returns corresponding Station object based on passed station name.
     * @param stationName
     * @return
     */
    public Station getStation(String stationName) {
        try {
            if(LIST_OF_STATIONS.containsKey(stationName)) {
                return LIST_OF_STATIONS.get(stationName);
            } else {
                throw  new NullPointerException("No such Station with that name.");
            }
        } catch (NullPointerException ex) {
            return null;
        }
    }

    /**
     * Returns all the Station objects in the MTR, in an ArrayList.
     * @return  ArrayList<Station>     ArrayList containing Station objects.
     */
    public HashMap<String, Station> getStations() {
        return LIST_OF_STATIONS;
    }
}
