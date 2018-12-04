package data_layer.exceptions;

public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = -7806029002430564887L;

    private String errorMessage;

    public NotFoundException() {
    }

    public NotFoundException(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
