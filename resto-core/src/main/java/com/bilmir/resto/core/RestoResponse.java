package com.bilmir.resto.core;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Builder
@Getter
public class RestoResponse<T> {

    private final HttpStatus httpStatus;
    private final Map<String, String> headers;
    private final T body;

}
