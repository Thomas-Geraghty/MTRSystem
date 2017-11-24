package controller;

import model.Line;
import model.MTR;
import model.Station;

import java.util.HashSet;
import java.util.Set;

public class MTRController implements Controller {

    private MTR mtr = MTR.getInstance();

    @Override
    public String listAllTermini() {
        String buffer = "";
        for(Line line : mtr.getLines().values()) {
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
        Line line1 = mtr.getLines().get(line);
        String buffer = "";
        for(int i = 0; i < line1.getStations().size(); i++) {
            buffer += (line1.getStations().get(i).getStationName());
            if(i < (line1.getStations().size() -1)) {
                buffer += " <-> ";
            }
        }
        return buffer;
    }

    @Override
    public String listAllDirectlyConnectedLines(String line) {
        Line line1 = mtr.getLines().get(line);
        Set<Line> linkedLines = new HashSet<Line>();
        String buffer = "";

        for(Station station : line1.getStations()) {
            linkedLines.addAll(station.getLines());
        }
        linkedLines.remove(line1);

        for(Line lines : linkedLines) {
            buffer += lines.getLineName();
            buffer += "\n";
        }
        return buffer;
    }

    @Override
    public String showPathBetween(String stationA, String stationB) {
        Station stationAObject = mtr.getStations().get(stationA);
        Station stationBObject = mtr.getStations().get(stationB);


        return mtr.getGraph().BFS(stationAObject,stationBObject);
    }
}