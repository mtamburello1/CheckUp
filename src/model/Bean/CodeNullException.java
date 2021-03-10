/**
 * 
 */
package model.Bean;

/**
 * This exception is thrown when an identifier code is null.
 * @author Tamburello Martina
 * 
 */
public class CodeNullException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CodeNullException() {
		super();
	}

	public CodeNullException(String message) {
		super(message);
	}

	
}
