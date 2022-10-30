package back.dto.microserviceResponse;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

/**
 {
 "meta": {
 "method": "GET",
 "operation": "/pom/people/v1/receiver/product"
 },
 "data": [],
 "errors": [
 {
 "code": "400",
 "detail": "identification and type specified are invalid"
 }
 ]
 }
 */

@Data
public class MicroserviceResponse<T> {

    private Meta meta;

    private T data;

    private List<Error> errors = new ArrayList<>();
}
