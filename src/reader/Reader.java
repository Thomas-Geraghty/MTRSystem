package reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * This class is responsible for reading the .csv files data. It reads the file,
 * so it can provide data for the interpreter.
 *
 * @author Joshua Gallagher
 * @author Thomas Geraghty
 * @author Dimitar Stoynev
 * 
 * @version 15/10/2017
 */
public class Reader {

	/**
	 * Holds the file location, ready to read the daat from it.
	 */
	private File file;

	/**
	 * The <code>FileReader</code> uses a <code>File</code>, so it can read the
	 * contents of the file as a stream of characters.
	 */
	private FileReader fr;

	/**
	 * The <code>BufferedReader</code> reads text from a character-input stream.
	 */
	private BufferedReader br;

	/**
	 * The <code>Reader</code>'s constructor. Requires one parameter:
	 * <code>fileLocation</code>.
	 * 
	 * @param fileLocation
	 * 
	 */
	public Reader(String fileLocation) {
		file = new File(fileLocation);
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		}
		br = new BufferedReader(fr);
	}

	/**
	 * This method is responsible for reading the data from the .csv file
	 * 
	 * It then takes this data and passes it to the <code>Interpreter</code>.
	 * 
	 * @return arrayOfLines <code>ArrayList</code> of all the lines with their
	 *         stations
	 */
	public ArrayList<ArrayList<String>> readFile() {

		ArrayList<ArrayList<String>> arrayOfLines = new ArrayList<>();

		String line = null;
		String[] lineList = null;
		String[] stationList = null;

		try {
			while ((line = br.readLine()) != null) {
				lineList = line.split("\\n");

				for (int i = 0; i < lineList.length; i++) {
					ArrayList<String> arrayOfStations = new ArrayList<>();

					arrayOfLines.add(arrayOfStations);
					stationList = lineList[i].split(",");

					for (int x = 0; x < stationList.length; x++) {
						arrayOfStations.add(stationList[x]);
					}
				}
			}
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		return arrayOfLines;
	}
}
