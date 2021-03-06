package de.awtools.rest;

import java.net.URI;

import javax.swing.JOptionPane;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import com.sun.net.httpserver.HttpServer;

import jakarta.ws.rs.core.UriBuilder;

public class Main {

    public static void main(String[] args) {
        URI baseUri = UriBuilder.fromUri("http://localhost/").port(9998).build();
        ResourceConfig config = new ResourceConfig(RestEndpoint.class);
        // RestApplication restApplication = new RestApplication();

        HttpServer httpServer = JdkHttpServerFactory.createHttpServer(baseUri, config);
        // httpServer.start();

        JOptionPane.showMessageDialog(null, "Ende");
        httpServer.stop(0);
    }

}
