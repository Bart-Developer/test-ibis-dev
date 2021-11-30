package back.services;

import back.models.Cars;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CarsService {
    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<?> getCarsFiltered() {
        try {
            URL url = new URL("https://server.cocoche.com.ar/car_listing_presentation?list_length=100");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            String externalAPI = "https://server.cocoche.com.ar/car_listing_presentation?list_length=100";
            Cars[] cars = restTemplate.getForObject(externalAPI, Cars[].class);
            List<Cars> carsFilters = Arrays.stream(cars).filter(x -> x.getBrandDescription().equalsIgnoreCase("FORD")).collect(Collectors.toList());

            return new ResponseEntity<>(carsFilters, HttpStatus.ACCEPTED);

        } catch (Exception e) {
            return new ResponseEntity<>("Exception in NetClientGet:- " + e, HttpStatus.BAD_GATEWAY);
        }
    }
}
