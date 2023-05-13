package adnmutation.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class DnaMutationException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private final String errorCode;
	private final String errorMessage;

}
