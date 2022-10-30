package back.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    public String ownerId;
    public String carId;
    public String title;
    public Long doors;
    public Long cost;
    public String url;
    public String fuelType;
    public String description;
    public String modelDescription;
    public String brandDescription;
    public String placeDescription;
    public String latitude;
    public String longitude;
    public String location;
    public Long calificationsAvg;
    public String currency;
    public Long year;
    public Long rentsQuantity;

}