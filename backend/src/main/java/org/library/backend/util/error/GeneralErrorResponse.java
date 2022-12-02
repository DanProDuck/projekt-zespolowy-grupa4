package org.library.backend.util.error;

import lombok.Data;

import java.sql.Timestamp;


@Data
public class GeneralErrorResponse {
    private String message;
    private Timestamp time;
}
