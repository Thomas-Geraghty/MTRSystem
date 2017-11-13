package Map;

import java.util.ArrayList;

public class Station {

    private String stationName;
    private ArrayList<Line> lines = new ArrayList<Line>();


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

    @Override
    public String toString() {
        return "" + stationName + " "+ getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
}
