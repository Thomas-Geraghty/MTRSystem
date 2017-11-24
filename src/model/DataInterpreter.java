package  model;

import java.util.ArrayList;
import java.util.HashMap;

public class DataInterpreter {

    public DataInterpreter() {
        interpretCSV();
    }

    private void interpretCSV() {
        Reader reader = new Reader();
        ArrayList<ArrayList<String>> lines = reader.readFile();
        HashMap<String, Station> importedStations = new HashMap<>();

        for(ArrayList<String> lineArray : lines) {
            Line line = new Line(lineArray.get(0));
            ArrayList<Station> stationsInLine = new ArrayList<Station>();

            for(int i = 1; i < lineArray.size(); i++) {
                String stationName = lineArray.get(i);
                Station station;

                if(importedStations.get(stationName) == null) {
                    station = new Station(stationName);
                    importedStations.put(stationName, station);
                } else {
                    station = importedStations.get(stationName);
                }
                line.addStation(station);
                station.addLine(line);
                MTR.getInstance().addStation(station);
            }

            for(int i = 0; i < line.getStations().size(); i++) {
                if(i > 0) {
                    line.getStations().get(i).addConnectedNode(line.getStations().get(i - 1));
                }
                if(i < (line.getStations().size() -1)) {
                    line.getStations().get(i).addConnectedNode(line.getStations().get(i + 1));
                }
            }
            MTR.getInstance().addLine(line);
        }
    }
}

