package org.library.backend.util.constants;

public enum StatusType {
    IN_BASKET("IN_BASKET"),
    AWAITING_FOR_PAYMENT("AWAITING_FOR_PAYMENT"),
    CANCELLED("CANCELLED"),
    IN_PROGRESS("IN_PROGRESS"),
    IN_RENT("IN_RENT"),
    IN_POSSESSION("IN_POSSESSION"),
    BOUGHT("BOUGHT"),
    RETURNED("RETURNED"),
    BEYOND_DUE_DATE("BEYOND_DUE_DATE"),
    LOST("LOST");

    StatusType(String status) {

    }
}
