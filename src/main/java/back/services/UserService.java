package back.services;

import back.dto.UserDTO;
import back.models.User;
import back.repositories.UserRepository;
import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ResponseEntity<?> CreateUser(@NotNull UserDTO userDTO) {

        if(userDTO.getEmail().isEmpty() || userDTO.getName().isEmpty() || userDTO.getPhone().isEmpty()){
            return new ResponseEntity<>("All fields are required", HttpStatus.FORBIDDEN);
        }

        if ( userRepository.existsByEmail(userDTO.getEmail())) {
            return new ResponseEntity<>("There is already a user with this email: " + userDTO.getEmail() , HttpStatus.FORBIDDEN);
        }

        User newUser = userRepository.save(new User(userDTO.getName(), userDTO.getPhone(), userDTO.getEmail()));

        return new ResponseEntity<>("id: " + newUser.getId() + ",\n" +  "createdAt: " + newUser.createdAt, HttpStatus.CREATED);
    }

}
