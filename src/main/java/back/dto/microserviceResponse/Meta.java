package back.dto.microserviceResponse;

import lombok.Data;

@Data
public class Meta {
	
	private String method;
	
	private String operation;

	public Meta(String method, String operation) {
		super();
		this.method = method;
		this.operation = operation;
	}
}