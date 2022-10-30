package back.services.http;

import back.dto.microserviceResponse.MicroserviceResponse;
import back.dto.microserviceResponse.utils.HttpInformation;
import back.dto.microserviceResponse.Error;
import java.util.List;

public interface ErrorService {
	
	/**
	 * Returns an array of {@link Error} containing all invalid keys
	 */

	MicroserviceResponse getErrorResponseForInvalidKeys(List<String> invalidKeys, String operation);

	/**
	 * Returns an error explaining that the request has expired.
	 */
	MicroserviceResponse getTimeoutResponse(String operation);
	
	/**
	 * Returns an error if the receiver fails delivering the message through gateway
	 */
	MicroserviceResponse getErrorResponse(String errorMessage, String operation);

	/**
	 * Returns an error from the processor
	 */
	MicroserviceResponse getProcessorErrorResponse(HttpInformation info);
	
}
