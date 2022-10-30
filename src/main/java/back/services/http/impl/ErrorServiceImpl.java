package back.services.http.impl;

import back.constants.ConstantValues;
import back.dto.microserviceResponse.Error;
import back.dto.microserviceResponse.Meta;
import back.dto.microserviceResponse.MicroserviceResponse;
import back.dto.microserviceResponse.utils.HttpInformation;
import back.services.http.ErrorService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ErrorServiceImpl implements ErrorService {

	@Override
	public MicroserviceResponse<ArrayList<Object>> getErrorResponseForInvalidKeys(List<String> invalidKeys, String operation) {
		MicroserviceResponse<ArrayList<Object>> response = getBasicErrorResponse(operation);
		List<Error> errors = new ArrayList<>();
		invalidKeys.forEach(k -> {
			Error e = new Error();
			e.setCode(ConstantValues.Error.ERR_COD_004);
			e.setDetail(String.format(ConstantValues.Error.Details.INVALID_INPUT_KEY, k));
			errors.add(e);
		});
		response.setErrors(errors);
		return response;
	}

	@Override
	public MicroserviceResponse getTimeoutResponse(String operation) {
		MicroserviceResponse<? extends ArrayList<Object>> response = getBasicErrorResponse(operation);
		Error e = new Error();
		e.setCode(ConstantValues.Error.ERR_COD_504);
		e.setDetail(ConstantValues.Error.Details.SERVICE_TIMEOUT);
		response.setErrors(List.of(e));
		return response;
	}

	@Override
	public MicroserviceResponse getErrorResponse(String errorMessage, String operation) {
		MicroserviceResponse<ArrayList<Object>> response = getBasicErrorResponse(operation);
		Error e = new Error();
		e.setCode(ConstantValues.Error.ERR_COD_006);
		e.setDetail(ConstantValues.Error.Details.ERROR + errorMessage);
		response.setErrors(List.of(e));
		return response;
	}
	
	@Override
	public MicroserviceResponse getProcessorErrorResponse(HttpInformation info) {
		MicroserviceResponse<ArrayList<Object>> response = getBasicErrorResponse(info.getOperation());
		Error e = new Error(info.getCode().toString(), info.getDetail());
		response.setErrors(List.of(e));
		return response;
	}
	
	private MicroserviceResponse<ArrayList<Object>> getBasicErrorResponse(String operation) {
		MicroserviceResponse<ArrayList<Object>> r = new MicroserviceResponse<>();
		r.setData(new ArrayList<>());
		r.setMeta(new Meta(ConstantValues.Http.METHOD_GET,operation));
		return r;
	}
}
