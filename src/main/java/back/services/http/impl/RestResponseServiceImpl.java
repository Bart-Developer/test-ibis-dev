package back.services.http.impl;

import back.dto.microserviceResponse.Meta;
import back.dto.microserviceResponse.MicroserviceResponse;
import back.dto.microserviceResponse.utils.HttpInformation;
import back.services.http.RestErrorService;
import back.services.http.RestResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class RestResponseServiceImpl implements RestResponseService {

	private final RestErrorService errorService;
	
	@Override
	public ResponseEntity<MicroserviceResponse<Object>> getResponse(HttpInformation httpInformation, Object payload) {
		
		Integer code = httpInformation.getCode();
		String operation = httpInformation.getOperation();
		String httpMethod = httpInformation.getHttpMethod().name();
		
		if (code == null || code.equals(200))
			return ResponseEntity.ok().body(getSuccessfulResponse(payload, operation, httpMethod));
		
		return ResponseEntity.status(code).body(errorService.getError(httpInformation));
	}
	
	private MicroserviceResponse<Object> getSuccessfulResponse(Object payload, String operation, String httpMethod) {
		MicroserviceResponse<Object> r = new MicroserviceResponse<>();
		r.setData(payload);
		r.setMeta(new Meta(httpMethod, operation));
		r.setErrors(new ArrayList<>());
		return r;
	}
}
