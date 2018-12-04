package data_layer.dto;

public class ErrorResponse {

    private String error;

    public ErrorResponse() {

    }

    public ErrorResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
