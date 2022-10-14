package com.kulsin.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        value = "jplaceholder",
        url = "https://jsonplaceholder.typicode.com/",
        configuration = FeignClientConfig.class,
        fallback = JSONPlaceHolderFallback.class
)
public interface JSONPlaceHolderClient {

    @GetMapping(value = "/posts")
    List<Post> getPosts();

    @GetMapping(value = "/posts/{postId}", produces = MediaType.APPLICATION_JSON_VALUE)
    Post getPostById(@PathVariable("postId") Long postId);

/*
        Feign client is composed of a set of customizable components.

        Spring Cloud creates a new default set on demand for each named client using the FeignClientsConfiguration class that we can customize.

        FeignClientsConfiguration contains these beans:

        Decoder – ResponseEntityDecoder, which wraps SpringDecoder, used to decode the Response
        Encoder – SpringEncoder is used to encode the RequestBody.
        Logger – Slf4jLogger is the default logger used by Feign.
        Contract – SpringMvcContract, which provides annotation processing
        Feign-Builder – HystrixFeign.Builder is used to construct the components.
        Client – LoadBalancerFeignClient or default Feign client

*/

}
