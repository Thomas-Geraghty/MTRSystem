package exceptions;

/**
 * <code>StationNotFoundException</code> should be thrown when a
 * <code>Station</code> can not be found. This is usually thrown after user
 * input.
 * 
 * @author Joshua Gallagher
 *
 */
public class StationNotFoundException extends Exception {

	/**
	 * Ensures that the sender and receiver of the serialised object have loaded
	 * classes for that object that are compatible with respect to serialisation.
	 */
	private static final long serialVersionUID = -8064834429218732836L;

	/**
	 * <code>StationNotFoundException</code> constructor. Expects one parameter:
	 * <code>message</code>.
	 * 
	 * @param message
	 *            The <code>message</code> that should be displayed when the
	 *            exception occurs.
	 */
	public StationNotFoundException(String message) {
		super(message);
	}
}
