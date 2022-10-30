package back.dto.microserviceResponse.utils;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

/**
 * Facilitates {@link HttpInformation} object creation for all the different configurations
 */

@Data
@NoArgsConstructor
public class HttpInformation {
	
	private Integer code;
	
	private String businessErrorCode;
	
	private String operation;
	
	private String detail;
	
	private String clazz;
	
	private HttpMethod httpMethod;


	public static class HttpInfoBuilder {
		
		private final HttpInformation httpInformation;
		
		public HttpInfoBuilder() {
			httpInformation = new HttpInformation();
		}

		public HttpInfoBuilder setCode(HttpStatus httpStatusCode) {
			httpInformation.code = httpStatusCode.value();
			return this;
		}

		public HttpInfoBuilder setOperation(String operation) {
			httpInformation.operation = operation;
			return this;
		}

		public HttpInfoBuilder setHttpMethod(HttpMethod httpMethod) {
			httpInformation.httpMethod = httpMethod;
			return this;
		}

		public HttpInformation build() {
			return httpInformation;
		}
	}
}
