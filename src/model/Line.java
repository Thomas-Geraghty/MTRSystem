package model;

import java.util.ArrayList;

/**
 * This class models a rail line from the MTR System. To mimic a line, this
 * class makes use of an <code>ArrayList</code> made up of
 * <code>Station</code>'s.
 * 
 * @author Joshua Gallagher
 * @author Thomas Geraghty
 * @author Dimitar Stoynev
 * 
 * @version 15/10/2017
 */
public class Line {

	/**
	 * Holds <code>Stations</code> in an <code>ArrayList</code>. The ArrayList is
	 * used to show a relationship between stations - what stations are connected to
	 * one another is a specific <code>Line</code>.
	 */
	private final ArrayList<Station> stationsInLine = new ArrayList<>();

	/**
	 * Stores the name of a given line, e.g. Tsuen Wan Line.
	 */
	private String lineName;

	/**
	 * The <code>Line</code> classes constructor.
	 * 
	 * Sets the <code>lineName</code>. E.g. the line name could be set to: Tsuen Wan
	 * Line.
	 * 
	 * @param lineName
	 *            The <code>Line</code> objects set name.
	 */
	public Line(String lineName) {
		this.lineName = lineName;
	}

	/**
	 * Returns a <code>Line</code> name.
	 * 
	 * @return lineName Returns the <code>Line</code>'s name.
	 */
	public String getLineName() {
		return this.lineName;
	}

	/**
	 * Adds a station to a line. If the <code>Line</code> was successfully added,
	 * then this method would return true, however, if it was not added it would
	 * return false.
	 * 
	 * @param station
	 *            The <code>Station</code> object to be added to a line.
	 */
	public boolean addStation(Station station) {
		return this.stationsInLine.add(station);
	}

	/**
	 * Returns the <code>ArrayList</code> of <code>stationsInLine</code>.
	 * 
	 * @return stationsInLine Returns an <code>ArrayList</code> of
	 *         <code>Station</code>'s.
	 */
	public ArrayList<Station> getStationsInLine() {
		return this.stationsInLine;
	}

	/**
	 * Returns the <code>Line</code> objects information. The <code>toString</code>
	 * method only returns a lines name when called.
	 * 
	 * @return string The lines name is returned when called on a <code>Line</code>
	 *         object.
	 */
	public String toString() {
		return this.lineName;
	}
}
