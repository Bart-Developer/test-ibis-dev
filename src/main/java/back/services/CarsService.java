package back.services;

import back.constants.CarsConstants;
import back.models.CarsList;
import back.models.Cars;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CarsService {

    private final WebClient webClient;

    public CarsService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("http://localhost:8080/api/get_ford_cars2")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public ResponseEntity<?> getCarsFiltered2() {
        try {
            List<CarsList> cars = webClient
                    .get()
                    .uri(CarsConstants.GET_ALL_CARS)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToFlux(CarsList.class)
                    .collectList()
                    .block();

            List<Cars> carsFiltered = Arrays.stream(cars.get(0).getCarList()).filter(x -> x.getBrandDescription().equalsIgnoreCase("FORD")).collect(Collectors.toList());
            return new ResponseEntity<>(carsFiltered, HttpStatus.OK);

        } catch (Exception e) {
            log.error("Fail call getById");
            return new ResponseEntity<>("There was a problem with the external API consulted: " + e , HttpStatus.BAD_REQUEST);
        }
    }
}
