package data_layer.exceptions;

public class OrderException extends RuntimeException {
    private static final long serialVersionUID = -7806029002430564887L;


    public OrderException(String errorMessage) {
        super(errorMessage);
    }


}
