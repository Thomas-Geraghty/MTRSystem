package controller;

import java.util.HashSet;
import java.util.List;

import exceptions.LineNotFoundException;
import exceptions.StationNotFoundException;
import model.AbstractNode;
import model.Line;
import model.MTR;
import model.Station;

/**
 * The <code>TUIController</code> handles talking to the Models and handing of
 * the data to the views.
 * 
 * This controller specifically, handles getting the data from
 * <code>AbstractNode</code>, <code>Station</code>, <code>Line</code> and
 * <code>MTR</code> models. This controller passes the data to
 * <code>TUIView</code>.
 * 
 * @author Joshua Gallagher
 * @author Thomas Geraghty
 * @author Dimitar Stoynev
 * 
 * @version 15/10/2017
 */
public class TUIController implements Controller {

	private MTR mtr;

	/**
	 * Creates an instance of <code>TUIController</code>. Requires one parameter -
	 * <code>mtr</code>.
	 * 
	 * @param mtr
	 *            The <code>MTR</code> represents an underground system made up of
	 *            lines and stations.
	 */
	public TUIController(MTR mtr) {
		this.mtr = mtr;
	}

	/**
	 * Returns a list of all the Termini in the MTR System.
	 * 
	 * @return buffer Returns all Termini in the MTR System as a
	 *         <code>String</code>.
	 */
	public String listAllTermini() {
		StringBuffer buffer = new StringBuffer();
		for (Line line : mtr.getLines().values()) {
			buffer.append("Line: ");
			buffer.append(line.getLineName());
			buffer.append("\n");
			buffer.append("Termini: ");
			buffer.append(line.getStationsInLine().get(0).getStationName());
			buffer.append(" <-> ");
			buffer.append(line.getStationsInLine().get(line.getStationsInLine().size() - 1).getStationName());
			buffer.append("\n\n");
		}
		return buffer.toString();
	}

	/**
	 * Lists all stations in a line, in the MTR system.
	 * 
	 * This method returns a string of stations that are connected to a
	 * <code>Line</code>.
	 * 
	 * @param line
	 *            The line that the user wants to see all stations that belong to
	 *            it.
	 * @return buffer Returns all the stations as a <code>String</code> belonging to
	 *         the specified line.
	 */
	public String listStationsInLine(String line) {
		StringBuffer buffer = new StringBuffer();
		try {
			Line line1 = mtr.getLine(line);
			buffer.append(line + ": ");
			for (int i = 0; i < line1.getStationsInLine().size(); i++) {
				buffer.append(line1.getStationsInLine().get(i).getStationName());
				if (i < (line1.getStationsInLine().size() - 1)) {
					buffer.append(" <-> ");
				}
			}
		} catch (LineNotFoundException e) {
			buffer.append(e.getMessage());
		}
		return buffer.toString();
	}

	/**
	 * Returns a list of all lines that are directly connected to a specific line.
	 * The <code>line</code> is specified by the user.
	 * 
	 * @param line
	 *            The line, which all other lines are connected to. Specified by the
	 *            user.
	 * @return buffer Returns <code>Lines</code> as a <code>String</code> to be
	 *         shown to the user.
	 */
	public String listAllDirectlyConnectedLines(String line) {
		StringBuffer buffer = new StringBuffer();
		try {
			Line line1 = mtr.getLine(line);
			HashSet<Line> linkedLines = new HashSet<Line>();

			for (Station station : line1.getStationsInLine()) {
				linkedLines.addAll(station.getStationInLines());
			}
			linkedLines.remove(line1);

			for (Line lines : linkedLines) {
				buffer.append(lines.getLineName());
				buffer.append("\n");
			}
		} catch (LineNotFoundException e) {
			buffer.append(e.getMessage());
		}
		return buffer.toString();
	}

	/**
	 * Finds the most efficient path between to given stations. Once a path is
	 * found, the trail between the start and end <code>Station</code> are returned.
	 * 
	 * @param stationA
	 *            The <code>Station</code> the user wants to begin at.
	 * @param stationB
	 *            The <code>Station</code> the user wants to get to.
	 * @return buffer Returns both <code>stationA</code> and <code>stationB</code>
	 *         with all the stations it has travelled through returned as a
	 *         formatted String.
	 */
	public String showPathBetween(String stationA, String stationB) {
		StringBuffer buffer = new StringBuffer();
		try {
			Station stationAObject = mtr.getStation(stationA);
			Station stationBObject = mtr.getStation(stationB);

			List<AbstractNode> stationList = stationAObject.bfsFromHere(stationBObject);

			buffer.append("Path: ");

			for (AbstractNode station : stationList) {
				buffer.append(station);
				if (!station.equals(stationList.get(stationList.size() - 1)))
					buffer.append(" -> ");
			}
		} catch (StationNotFoundException e) {
			buffer.append(e.getMessage());
		}
		return buffer.toString();
	}
}