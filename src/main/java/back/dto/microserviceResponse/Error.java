
package back.dto.microserviceResponse;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Error {
	
	private String code;
	private String detail;

	public Error(String code, String detail) {
		this.code = "ERR_MSG" + code;
		this.detail = detail;
	}
}
