package back.services.impl;

import back.constants.ConstantValues;
import back.dto.UserDTO;
import back.exception.DuplicateDataException;
import back.exception.FormatNotValidException;
import back.exception.IncompleteFieldsException;
import back.models.User;
import back.repositories.UserRepository;
import back.services.UserService;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.regex.Matcher;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(@NotNull UserDTO userDTO) throws FormatNotValidException, DuplicateDataException, IncompleteFieldsException {

        Matcher matcher = ConstantValues.Validate.VALID_EMAIL_ADDRESS_REGEX.matcher(userDTO.getEmail());

        if(userDTO.getEmail().isEmpty() || userDTO.getName().isEmpty() || userDTO.getPhone().isEmpty()){
            throw new IncompleteFieldsException();
        }

        if ( userRepository.existsByEmail(userDTO.getEmail())) {
            throw new DuplicateDataException(userDTO.getEmail());
        }

        if(!matcher.find()) {
            throw new FormatNotValidException();
        }

        return userRepository.save(new User(userDTO.getName(), userDTO.getPhone(), userDTO.getEmail()));
    }
}
