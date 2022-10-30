package back.services.http.impl;

import back.constants.ConstantValues;
import back.dto.microserviceResponse.Error;
import back.dto.microserviceResponse.Meta;
import back.dto.microserviceResponse.MicroserviceResponse;
import back.dto.microserviceResponse.utils.HttpInformation;
import back.services.http.RestErrorService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestErrorServiceImpl implements RestErrorService {

	@Override
	public MicroserviceResponse<Object> getError(HttpInformation httpInformation) {
		MicroserviceResponse<Object> response = getBasicErrorResponse(httpInformation.getOperation(),
				httpInformation.getHttpMethod().name());
		String detail = getFullDetail(httpInformation.getClazz(), httpInformation.getDetail());
		Error e = new Error(httpInformation.getCode().toString(), detail);
		response.setErrors(List.of(e));
		return response;
	}

	private List<Error> buildInvalidProductsErrorList(List<String> invalidProductsList) {
		return invalidProductsList.stream().map(s -> new Error(ConstantValues.Error.ERR_COD_004,
				String.format(ConstantValues.Error.Details.INVALID_INPUT_KEY, s))).collect(Collectors.toList());
	}

	private MicroserviceResponse<Object> getBasicErrorResponse(String operation, String httpMethod) {
		MicroserviceResponse<Object> r = new MicroserviceResponse<>();
		r.setData(new ArrayList<>());
		r.setMeta(new Meta(httpMethod, operation));
		return r;
	}

	private String getFullDetail(String clazz, String message) {
		return String.format("%s, exception: %s", message, clazz);
	}
}