package model;

import java.util.ArrayList;
import java.util.HashMap;

public class DataInterpreter {

    public DataInterpreter(Reader input) {
        interpretCSV(input);
    }

    private void interpretCSV(Reader input) {
        ArrayList<ArrayList<String>> lines = input.readFile();
        HashMap<String, Station> importedStations = new HashMap<>();

        for(ArrayList<String> lineArray : lines) {
            Line line = new Line(lineArray.get(0));

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

            for(int i = 0; i < line.getSTATIONS_IN_LINE().size(); i++) {
                if(i > 0) {
                    line.getSTATIONS_IN_LINE().get(i).addConnectedNode(line.getSTATIONS_IN_LINE().get(i - 1));
                }
                if(i < (line.getSTATIONS_IN_LINE().size() -1)) {
                    line.getSTATIONS_IN_LINE().get(i).addConnectedNode(line.getSTATIONS_IN_LINE().get(i + 1));
                }
            }
            MTR.getInstance().addLine(line);
        }
    }
}

