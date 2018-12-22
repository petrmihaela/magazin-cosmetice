package data_layer.exceptions;

public class OrderException extends RuntimeException {
    private static final long serialVersionUID = -7806029002430564887L;

    private String errorMessage;

    public OrderException() {
    }

    public OrderException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
