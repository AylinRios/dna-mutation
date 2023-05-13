package adnmutation.exceptions;

public class NotFoundException extends DnaMutationException {

	private static final long serialVersionUID = 1L;

	public NotFoundException(String errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}

}
