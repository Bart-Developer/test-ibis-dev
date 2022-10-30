package back.controller;

import back.constants.ConstantValues;
import back.dto.UserDTO;
import back.dto.microserviceResponse.MicroserviceResponse;
import back.dto.microserviceResponse.utils.HttpInformation;
import back.exception.DuplicateDataException;
import back.exception.FormatNotValidException;
import back.exception.IncompleteFieldsException;
import back.models.User;
import back.services.UserService;
import back.services.http.RestResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping(ConstantValues.URI.BASE_PATH)
public class UserController {

   private final UserService userService;
    private final RestResponseService restResponseService;

    @PostMapping("/create_user")
    public ResponseEntity<MicroserviceResponse<Object>> createUser(@RequestBody UserDTO userDTO, HttpServletRequest request) throws FormatNotValidException, DuplicateDataException, IncompleteFieldsException {

        User response = userService.createUser(userDTO);
        return restResponseService.getResponse(
                new HttpInformation.HttpInfoBuilder()
                        .setCode(HttpStatus.OK)
                        .setOperation(String.format(ConstantValues.Http.GET_ONLY_FORD_CARS_ENDPOINT, request.getRequestURI(), request.getQueryString()))
                        .setHttpMethod(HttpMethod.GET)
                        .build()
                , response);
    }
}
