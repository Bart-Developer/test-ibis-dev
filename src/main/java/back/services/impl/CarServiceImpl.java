package back.services.impl;

import back.constants.CarBrand;
import back.constants.ConstantValues;
import back.exception.NotFoundException;
import back.services.CarService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import back.models.CarsList;
import back.models.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CarServiceImpl implements CarService {

    private final WebClient webClient;
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public CarServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @Value("${api.url}")
    private URI API;

    @Override
    public List<Car> getCarsFiltered(CarBrand brand) throws Exception {

        switch (brand) {
            case FORD:
            case VOLKSWAGEN:
            case PEUGEOT:
                log.info("looking for cars by brand {}", brand.value());
                break;
            default: throw new NotFoundException();
        }

        try {
            List<CarsList> cars = webClient
                    .get()
                    .uri(API + ConstantValues.URI.GET_ALL_CARS)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToFlux(CarsList.class)
                    .collectList()
                    .block();

            List<Car> carFiltered = Arrays.stream(cars.stream()
                            .findFirst().get().getCarList()).
                    filter(x -> x.getBrandDescription().equalsIgnoreCase(brand.value()))
                    .collect(Collectors.toList());

            if (carFiltered.isEmpty()) {
                log.error("No cars with that name");
                throw new NotFoundException();
            }

            log.info(gson.toJson(carFiltered));
            return carFiltered;

        } catch (Exception e) {
            log.error("Fail call Get By Brand Description");
            throw new Exception("There was a problem with the external API consulted: " + e);
        }
    }
}
