package org.example.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.util.Constant;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class ErrorResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String errorType ;
    private String message;
    private int status;


    public ErrorResponse(String errorType, String message, int status) {
        super();
        this.errorType = errorType;
        this.message = message;
        this.status = status;
    }

    public ErrorResponse(String errorType, String message) {
        super();
        this.errorType = errorType;
        this.message = message;
        this.status = Constant.Code.BAD_REQUEST;
    }

}
