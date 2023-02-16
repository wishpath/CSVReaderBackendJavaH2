package b3_web_csv_uploader.exception;

public class FileStorageException extends RuntimeException {
	
	private static final long serialVersionUID = -1987638062889701445L;

	public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
