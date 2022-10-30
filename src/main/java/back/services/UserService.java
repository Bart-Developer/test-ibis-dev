package back.services;

import back.dto.UserDTO;
import back.exception.DuplicateDataException;
import back.exception.FormatNotValidException;
import back.exception.IncompleteFieldsException;
import back.models.User;
import com.sun.istack.NotNull;

public interface UserService {
    User createUser(@NotNull UserDTO userDTO) throws FormatNotValidException, DuplicateDataException, IncompleteFieldsException;
}
