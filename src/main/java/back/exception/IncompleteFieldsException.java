package back.exception;

import back.constants.ConstantValues;
import org.springframework.http.HttpStatus;

public class IncompleteFieldsException extends CarsException{

    private static final long serialVersionUID = -3833723730775696584L;

    public IncompleteFieldsException() {
        super(ConstantValues.Error.INCOMPLETE_DATA_REQUIRED, HttpStatus.NOT_FOUND);
    }

    public IncompleteFieldsException(String filter) {
        super(String.format(ConstantValues.Error.INCOMPLETE_DATA_REQUIRED, filter), HttpStatus.NOT_FOUND);
    }
}
