package model;

import java.util.HashMap;
import java.util.Map;

import exceptions.LineNotFoundException;
import exceptions.StationNotFoundException;

/**
 * This class is responsible for building the MTR System's <code>Line</code>'s
 * and <code>Station</code>'s.
 * 
 * @author Joshua Gallagher
 * @author Thomas Geraghty
 * @author Dimitar Stoynev
 * @version 15/10/2017
 */
public class MTR {

	/**
	 * Stores the name of the line and a <code>Line</code> object in a
	 * <code>Map</code>.
	 */
	private final Map<String, Line> listOfLines;

	/**
	 * Stores the name of a station and a <code>Station</code> object in a
	 * <code>Map</code>.
	 */
	private final Map<String, Station> listOfStations;

	/**
	 * The <code>MTR</code> classes constructor. The <code>listOfLines</code>
	 * <code>HashMap</code> and <code>listOfStations</code> <code>HashMap</code> is
	 * initialised for use.
	 */
	public MTR() {
		this.listOfLines = new HashMap<>();
		this.listOfStations = new HashMap<>();
	}

	/**
	 * Adds a <code>Line</code> object to <code>listOfLines</code> in the MTR
	 * System.
	 * 
	 * @param line
	 *            <code>Line</code> object to be added to <code>listOfLines</code>.
	 */
	public void addLine(Line line) {
		listOfLines.put(line.getLineName(), line);
	}

	/**
	 * Returns the corresponding <code>Line</code> object from a line's name. The
	 * lines name is a parameter to be passed in.
	 * 
	 * @param lineName
	 *            The <code>Line</code>'s name.
	 * @return Line Returns a <code>Line</code> object by its <code>lineName</code>.
	 * @throws LineNotFoundException
	 *             This exception is thrown when a line can not be found.
	 */
	public Line getLine(String lineName) throws LineNotFoundException {
		if (!listOfLines.containsKey(lineName)) {
			throw new LineNotFoundException("No such line with that name!");
		}
		return listOfLines.get(lineName);
	}

	/**
	 * Returns all the <code>Line</code> objects in the <code>MTR</code>, in an
	 * <code>ArrayList</code>.
	 * 
	 * @return listOfLines Returns the <code>listOfLines</code>, which contains all
	 *         line in the <code>MTR</code>.
	 */
	public Map<String, Line> getLines() {
		return listOfLines;
	}

	/**
	 * Add a <code>Station</code> to the <code>listOfStations</code>
	 * <code>Map</code>.
	 * 
	 * @param station
	 *            <code>Station</code> object to add to the
	 *            <code>listOfStations</code>.
	 */
	public void addStation(Station station) {
		listOfStations.put(station.getStationName(), station);
	}

	/**
	 * Returns corresponding <code>Station</code> object based on passed
	 * <code>stationName</code>.
	 * 
	 * @param stationName
	 *            The <code>stationName</code> is used to get a specific
	 *            <code>Station</code> from <code>listOfStations</code>.
	 * @return Station Returns a <code>Station</code> object.
	 * @throws StationNotFoundException
	 *             This exception is thrown when a station can not be found.
	 */
	public Station getStation(String stationName) throws StationNotFoundException {
		if (!listOfStations.containsKey(stationName)) {
			throw new StationNotFoundException("No such station with that name!");
		}
		return listOfStations.get(stationName);
	}

	/**
	 * Returns all the <code>Station</code> objects in the <code>MTR</code>, in an
	 * <code>ArrayList</code>.
	 * 
	 * @return listOfStations Returns an <code>ArrayList</code> containing
	 *         <code>Station</code> objects.
	 */
	public Map<String, Station> getStations() {
		return listOfStations;
	}
}
