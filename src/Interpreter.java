import java.util.ArrayList;
import Map.*;
import model.Line;
import model.Station;

public class Interpreter {

    public static void main(String[] args) {
        Interpreter interpreter = new Interpreter();
    }

    public Interpreter() {
        interpretCSV();
        InputReader input = new InputReader();
        input.getInput();
    }

    private void interpretCSV() {
        Reader reader = new Reader();

        ArrayList<ArrayList<String>> lineList = new ArrayList<>();
        lineList = reader.readFile();

        for(int i  = 0; i < lineList.size(); i++) {

            Line line = new Line(lineList.get(i).get(0));

            Map.getInstance().addLine(line);

            for(int z = 1; z < lineList.get(i).size(); z++) {

                String stationName = lineList.get(i).get(z);
                Station station = new Station(stationName);
                station.addLine(line);

                Map.getInstance().addStation(station);
            }
        }
    }
}
