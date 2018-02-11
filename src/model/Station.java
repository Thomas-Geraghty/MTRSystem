package model;

import java.util.HashSet;
import java.util.Set;

/**
 * This class models a railway <code>Station</code> from the MTR System and then
 * puts it in its associated line.
 * 
 * @author Joshua Gallagher
 * @author Thomas Geraghty
 * @author Dimitar Stoynev
 * @version 15/10/2017
 */
public class Station extends AbstractNode {

	/**
	 * 
	 */
	private final Set<Line> stationInLines = new HashSet<>();

	/**
	 * Stores the name of a given station, e.g. Sunny Bay.
	 */
	private String stationName;

	/**
	 * The <code>Station</code> classes constructor.
	 * 
	 * Sets the <code>stationName</code>. E.g. the station name could be set to:
	 * Sunny Bay.
	 * 
	 * @param stationName
	 *            The <code>Station</code> objects set name.
	 */
	public Station(String stationName) {
		this.stationName = stationName;
	}

	/**
	 * Returns a <code>Station</code> name.
	 * 
	 * @return stationName Returns the <code>Station</code>'s name.
	 */
	public String getStationName() {
		return this.stationName;
	}

	/**
	 * Adds a <code>Station</code to a <code>Line</code>.
	 * 
	 * @param line
	 *            A <code>Line</code> object.
	 */
	public boolean addLine(Line line) {
		return stationInLines.add(line);
	}

	/**
	 * Returns an <code>ArrayList</code> containing what <code>Line</code>'s a
	 * <code>Station</code> is part of.
	 * 
	 * @return stationInLines Returns an <code>ArrayList</code> of
	 *         <code>Stations</code>'s.
	 */
	public Set<Line> getStationInLines() {
		return stationInLines;
	}

	/**
	 * Returns the <code>Station</code> objects information. The
	 * <code>toString</code> method only returns a stations name when called.
	 * 
	 * @return string The station name is returned when called on a
	 *         <code>Station</code> object.
	 */
	public String toString() {
		return this.stationName;
	}
}
