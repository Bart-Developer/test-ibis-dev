package back.exception;

import org.springframework.http.HttpStatus;

public abstract class CarsException extends Exception {

	private final HttpStatus httpStatus;

	private static final long serialVersionUID = -8445868417150014926L;

	public CarsException(String message) {
		super(message);
		this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
	}

	public CarsException(String message, HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
}
