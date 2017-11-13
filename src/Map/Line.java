package Map;

import java.util.ArrayList;

public class Line {

    private String lineName;
    private ArrayList<Station> stations = new ArrayList<Station>();


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
        stations.add(station);
    }

    /**
     * Returns all stations of line.
     * @return
     */
    public ArrayList<Station> getStations() {
        return stations;
    }

    @Override
    public String toString() {
        return "Line " + lineName + " "+ getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
}
