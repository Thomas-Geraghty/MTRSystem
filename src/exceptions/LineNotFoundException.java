package exceptions;

/**
 * <code>LineNotFoundException</code> should be thrown when a <code>Line</code>
 * can not be found. This is usually thrown after user input.
 * 
 * @author Joshua Gallagher
 *
 */
public class LineNotFoundException extends Exception {

	/**
	 * Ensures that the sender and receiver of the serialised object have loaded
	 * classes for that object that are compatible with respect to serialisation.
	 */
	private static final long serialVersionUID = 624198833453373737L;

	/**
	 * <code>LineNotFoundException</code> constructor. Expects one parameter:
	 * <code>message</code>.
	 * 
	 * @param message
	 *            The <code>message</code> that should be displayed when the
	 *            exception occurs.
	 */
	public LineNotFoundException(String message) {
		super(message);
	}

}
