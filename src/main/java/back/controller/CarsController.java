package back.controller;

import back.constants.CarBrand;
import back.constants.ConstantValues;
import back.dto.microserviceResponse.MicroserviceResponse;
import back.dto.microserviceResponse.utils.HttpInformation;
import back.models.Car;
import back.services.CarService;
import back.services.http.RestResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(ConstantValues.URI.BASE_PATH)
@RequiredArgsConstructor
public class CarsController {

    private final CarService carService;
    private final RestResponseService restResponseService;


    @GetMapping(ConstantValues.URI.GET_CARS_BY_BRAND)
    public ResponseEntity<MicroserviceResponse<Object>> getCarsByBrand(@PathVariable("brand") String brand, HttpServletRequest request) throws Exception {

        CarBrand carBrand = CarBrand.findValue(brand);

        List<Car> response = this.carService.getCarsFiltered(carBrand);

        return restResponseService.getResponse(
                new HttpInformation.HttpInfoBuilder()
                        .setCode(HttpStatus.OK)
                        .setOperation(String.format(ConstantValues.Http.GET_ONLY_FORD_CARS_ENDPOINT, request.getRequestURI(), request.getQueryString()))
                        .setHttpMethod(HttpMethod.GET)
                        .build()
                , response);
    }
}
