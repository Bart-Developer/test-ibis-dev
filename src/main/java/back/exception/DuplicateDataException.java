package back.exception;

import back.constants.ConstantValues;
import org.springframework.http.HttpStatus;

public class DuplicateDataException extends CarsException{

    private static final long serialVersionUID = -3833723730775696584L;

    public DuplicateDataException(String email) {
        super(ConstantValues.Error.DUPLICATE_DATA, HttpStatus.FORBIDDEN);
    }

}
