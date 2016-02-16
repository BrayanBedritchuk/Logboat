package br.com.sailboat.logboat;

public class FileChooserCanceledException extends Exception {

	private static final long serialVersionUID = 5568918116991019871L;

	public FileChooserCanceledException() {
	}

	public FileChooserCanceledException(String message) {
		super(message);
	}

	public FileChooserCanceledException(Throwable cause) {
		super(cause);
	}

	public FileChooserCanceledException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileChooserCanceledException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
