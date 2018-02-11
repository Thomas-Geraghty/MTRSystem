package core;

import controller.TUIController;
import model.MTR;
import reader.Interpreter;
import reader.Reader;
import view.TUIView;

/**
 * The <code>MTRSystem<code> is the class which contains the entry point to this
 * program.
 *
 * @author Joshua Gallagher
 * @author Thomas Geraghty
 * @author Dimitar Stoynev
 *
 * @version 15/10/2017
 */
public class MTRSystem {

	/**
	 * MTRSystem is the core class. This class brings all the components together,
	 * from within the system.
	 *
	 * It passes the the data files location to the <code>Reader</code>, which is
	 * passed with an instance of <code>MTR</code> to the <code>Interpreter</code>
	 * to create a model of the underground system.
	 *
	 * Then, the text based view is set up to present the output of the program to a
	 * user.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		MTR mtr = new MTR();
		new Interpreter(new Reader("resources/MTRsystem_partial.csv"), mtr);
		new TUIView(new TUIController(mtr));
	}

}
