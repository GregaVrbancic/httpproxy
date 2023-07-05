package xyz.grega.app.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import jakarta.inject.Inject;
import xyz.grega.app.utils.Client;

@Controller("/")
public class HttpController {

    private static Logger logger = LoggerFactory.getLogger(HttpController.class);

    @Inject
    private Client client;
    
    @Get
    public String proxyUrl(@QueryValue String url) {
        logger.info("Passed URL: " + url);
        return client.proxyUrl(url);
    }
}
