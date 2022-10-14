package com.kulsin.client;

import feign.Logger;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import feign.okhttp.OkHttpClient;
import org.apache.http.entity.ContentType;
import org.springframework.context.annotation.Bean;

public class FeignClientConfig {

    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }

/*
    To add the interceptor to the request chain, add the bean to our Configuration class or,
    declare it in the properties file:

    feign:
        client:
            config:
                default:
                    requestInterceptors:
                        com.baeldung.cloud.openfeign.JSONPlaceHolderInterceptor

Alternatively, we can use the BasicAuthRequestInterceptor class that the Spring Cloud OpenFeign provides:

@Bean
public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
    return new BasicAuthRequestInterceptor("username", "password");
}

*/

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("user", "admin");
            requestTemplate.header("password", "admin");
            requestTemplate.header("Accept", ContentType.APPLICATION_JSON.getMimeType());
        };
    }

    /*
     * There are four logging levels to choose from:
     *     NONE – no logging, which is the default
     *     BASIC – log only the request method, URL and response status
     *     HEADERS – log the basic information together with request and response headers
     *     FULL – log the body, headers and metadata for both request and response
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }

}
