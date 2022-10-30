package back.services.http;

import back.dto.microserviceResponse.MicroserviceResponse;
import back.dto.microserviceResponse.utils.HttpInformation;
import org.springframework.http.ResponseEntity;

public interface RestResponseService {
	ResponseEntity<MicroserviceResponse<Object>> getResponse(HttpInformation httpInformation, Object payload);
}
