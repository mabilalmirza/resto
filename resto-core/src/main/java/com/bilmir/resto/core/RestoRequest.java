package com.bilmir.resto.core;

import lombok.*;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import java.util.Map;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
public class RestoRequest {

    private final HttpMethod method;
    private final String url;
    private final String finalUrl;

    @Singular
    private final Map<String, String> pathsParams;

    private final MultiValuedMap<String, String> queryParams;

    @Singular
    private final Map<String, String> headers;

    private final Object body;

    public static final class RestoRequestBuilder {

        private MultiValuedMap<String, String> queryParams = new ArrayListValuedHashMap<>();

        public RestoRequestBuilder queryParam(String name, Object value) {
            if (value != null) {
                this.queryParams.put(name, String.valueOf(value));
            }
            return this;
        }

    }
}
