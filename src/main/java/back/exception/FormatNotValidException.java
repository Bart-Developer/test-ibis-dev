package back.exception;

import back.constants.ConstantValues;
import org.springframework.http.HttpStatus;

public class FormatNotValidException extends CarsException{

    private static final long serialVersionUID = -3833723730775696584L;

    public FormatNotValidException() {
        super(ConstantValues.Error.NOT_FORMAT_VALID, HttpStatus.FORBIDDEN);
    }
}
