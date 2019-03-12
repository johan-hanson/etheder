package se.webinfostudio.game.etheder.dataimport;

public class DataImportException extends Exception {

	private static final long serialVersionUID = -7336651731107040208L;

	public DataImportException() {
		super();
	}

	/**
	 * .
	 *
	 * @param ex {@link Exception}
	 */
	public DataImportException(final Exception ex) {
		super(ex);
	}
}
