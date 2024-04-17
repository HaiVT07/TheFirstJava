package org.example.exceptions;

public class ProductException extends  RuntimeException  {
    private static final long serialVersionUID = 1L;

    private ErrorResponse errorResponse;

    public ProductException(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }

}
