package com.bilmir.resto.core;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class HttpRequest {

    private final HttpMethod method;
    private final String url;
    private final String finalUrl;
    private final Map<String, String> pathsParams;
    private final MultiValuedMap<String, String> queryParams;
    private final Map<String, String> headers;
    private final Object body;

    public static HttpRequestBuilder builder() {
        return new HttpRequestBuilder();
    }

    @Accessors(fluent = true)
    @Setter
    public static final class HttpRequestBuilder {

        private HttpMethod method;
        private String url;
        private Map<String, String> pathsParams = new HashMap<>();
        private MultiValuedMap<String, String> queryParams = new ArrayListValuedHashMap<>();
        private Map<String, String> headers = new HashMap<>();
        private Object body;

        public HttpRequestBuilder pathParam(String name, String value) {
            this.pathsParams.put(name, value);
            return this;
        }

        public HttpRequestBuilder queryParam(String name, Object value) {
            if (value != null) {
                this.queryParams.put(name, String.valueOf(value));
            }
            return this;
        }

        public HttpRequestBuilder header(String name, String value) {
            this.headers.put(name, value);
            return this;
        }

        public HttpRequest build() {
            String finalUrl = null; //TODO calculate
            return new HttpRequest(method, url, finalUrl, pathsParams, queryParams, headers, body);
        }
    }
}
