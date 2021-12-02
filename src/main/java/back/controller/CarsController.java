package back.controller;

import back.services.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CarsController {

    @Autowired
    CarsService carsService;

    @GetMapping("/get_ford_cars")
    public ResponseEntity<?> getCarsFiltered() {
        return this.carsService.getCarsFiltered2();
    }
}
