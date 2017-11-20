package  model;

import controller.MTRController;

import java.util.ArrayList;

public class DataInterpreter {

    public DataInterpreter() {
        interpretCSV();
    }

    private void interpretCSV() {
        Reader reader = new Reader();
        ArrayList<ArrayList<String>> lineList = reader.readFile();

        for(int i  = 0; i < lineList.size(); i++) {

            Line line = new Line(lineList.get(i).get(0));

            MTR.getInstance().addLine(line);

            for(int z = 1; z < lineList.get(i).size(); z++) {

                String stationName = lineList.get(i).get(z);
                Station station = new Station(stationName);
                station.addLine(line);

                 MTR.getInstance().addStation(station);
            }
        }
    }
}

