package adnmutation.assertions;


import adnmutation.constants.ErrorCodes;
import adnmutation.exceptions.NotFoundException;

import java.util.Objects;

public class Assertions {
	
	public static void isNull(final String entityName, final Object entity) {
		final String errorMessage = String.format("Entity %s is not found", entityName);
		
		if(Objects.isNull(entity)) {
			throw new NotFoundException(ErrorCodes.NOT_FOUND, errorMessage);
		}
	}

}
