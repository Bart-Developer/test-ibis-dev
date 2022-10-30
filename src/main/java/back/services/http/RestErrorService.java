package back.services.http;

import back.dto.microserviceResponse.MicroserviceResponse;
import back.dto.microserviceResponse.utils.HttpInformation;

public interface RestErrorService {
	MicroserviceResponse<Object> getError(HttpInformation httpInformation);
}
