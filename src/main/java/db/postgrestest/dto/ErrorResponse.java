package db.postgrestest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    private Integer code;
    private String message;

    public ErrorResponse(String message) {
        this.message = message;
    }
}
