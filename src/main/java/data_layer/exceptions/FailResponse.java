package data_layer.exceptions;

public class FailResponse {
    private String message;

    public FailResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
