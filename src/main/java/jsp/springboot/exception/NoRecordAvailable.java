package jsp.springboot.exception;

public class NoRecordAvailable  extends RuntimeException{
	public NoRecordAvailable( String message) {
		super(message);
	}

}
