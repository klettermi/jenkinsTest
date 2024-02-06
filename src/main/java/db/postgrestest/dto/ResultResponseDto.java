package db.postgrestest.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ResultResponseDto {
    private ErrorResponse error;
    private Object payload;
}
