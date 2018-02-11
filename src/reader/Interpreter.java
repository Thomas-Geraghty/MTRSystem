package reader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.Line;
import model.MTR;
import model.Station;

/**
 * This class is responsible for interpreting the .csv files data. Once it has
 * interpreted the whole file, it build the system.
 * 
 * @author Joshua Gallagher
 * @author Thomas Geraghty
 * @author Dimitar Stoynev
 * 
 * @version 15/10/2017
 */
public class Interpreter {

	/**
	 * The <code>Interpreter</code>'s constructor. Requires two parameters:
	 * <code>Reader</code> and <code>MTR</code>.
	 * 
	 * @param input
	 * @param mtr
	 */
	public Interpreter(Reader input, MTR mtr) {
		interpretCSV(input, mtr);
	}

	/**
	 * This method is responsible for interpreting the recieved from the
	 * <code>Reader</code>.
	 * 
	 * It then takes this data and builds the <code>MTR</code> - the
	 * <code>Station</code>'s and <code>Line</code>'s.
	 * 
	 * @param input
	 *            The <code>Reader</code> is passed in to get the data from the .csv
	 *            and pass it into this method.
	 * @param mtr
	 *            An instance of <code>MTR</code> is required to build the system
	 *            from the interpreted data.
	 */
	private void interpretCSV(Reader input, MTR mtr) {
		ArrayList<ArrayList<String>> lines = input.readFile();
		Map<String, Station> importedStations = new HashMap<>();

		for (ArrayList<String> lineArray : lines) {
			Line line = new Line(lineArray.get(0));

			for (int i = 1; i < lineArray.size(); i++) {
				Station station;
				String stationName = lineArray.get(i);

				if (importedStations.get(stationName) == null) {
					station = new Station(stationName);
					importedStations.put(stationName, station);
				} else {
					station = importedStations.get(stationName);
				}
				line.addStation(station);
				station.addLine(line);
				mtr.addStation(station);
			}

			for (int i = 0; i < line.getStationsInLine().size(); i++) {
				if (i > 0) {
					line.getStationsInLine().get(i).addConnectedNode(line.getStationsInLine().get(i - 1));
				}
				if (i < (line.getStationsInLine().size() - 1)) {
					line.getStationsInLine().get(i).addConnectedNode(line.getStationsInLine().get(i + 1));
				}
			}
			mtr.addLine(line);
		}
	}
}
