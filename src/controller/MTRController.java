package controller;

import model.Line;
import model.MTR;
import model.Station;

public class MTRController implements Controller {

    private MTR mtr = MTR.getInstance();

    @Override
    public String listAllTermini() {
        String buffer = "";
        for(Line line : mtr.getLineList().values()) {
            String[] termini = new String[2];
            termini[0] = line.getStations().get(0).getStationName();
            termini[1] = line.getStations().get(line.getStations().size() - 1).getStationName();

            buffer += ("Line: " + line.getLineName());
            buffer += ("\n");
            buffer += (termini[0] + " <-> " + termini[1]);
            buffer += ("\n\n");
        }
        return buffer;
    }

    @Override
    public String listStationsInLine(String line) {
        return null;
    }

    @Override
    public String listAllDirectlyConnectedLines(String line) {
        return null;
    }

    @Override
    public String showPathBetween(String stationA, String stationB) {
        return null;
    }
}