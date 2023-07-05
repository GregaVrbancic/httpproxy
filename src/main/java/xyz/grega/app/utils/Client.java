package xyz.grega.app.utils;

import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.http.client.HttpClient;
import jakarta.inject.Singleton;

@Singleton
public class Client {

    private static Logger logger = LoggerFactory.getLogger(Client.class);

    public String proxyUrl(String url) {
        try (HttpClient httpClient = HttpClient.create(new URL(url))) {
            return httpClient.toBlocking().retrieve(url);
        } catch (Exception e) {
            logger.info(e.toString());
            return e.getMessage();
        }
    }
    
}
