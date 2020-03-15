package com.bilmir.resto.core;

import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class RestoService {

    private String context;
    private List<UnaryOperator<RestoRequest>> requestInterceptors;
    private List<UnaryOperator<RestoResponse>> responseInterceptors;

}
