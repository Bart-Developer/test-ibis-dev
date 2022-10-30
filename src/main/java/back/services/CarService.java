package back.services;

import back.constants.CarBrand;
import back.models.Car;
import java.util.List;

public interface CarService {
    List<Car> getCarsFiltered(CarBrand brand) throws Exception;
}
