package back.exception;

import back.constants.ConstantValues;
import org.springframework.http.HttpStatus;

public class NotFoundException extends CarsException{

    private static final long serialVersionUID = -3833723730775696584L;

    public NotFoundException() {
        super(ConstantValues.Error.EMPTY_DATA, HttpStatus.NOT_FOUND);
    }

    public NotFoundException(String filter) {
        super(String.format(ConstantValues.Error.EMPTY_DATA_FILTER, filter), HttpStatus.NOT_FOUND);
    }
}
