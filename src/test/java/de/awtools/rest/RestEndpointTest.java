package de.awtools.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.jupiter.api.Test;

import jakarta.ws.rs.core.Application;

public class RestEndpointTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(RestEndpoint.class);
    }

    @Test
    public void test() {
        final String hello = target("/notifications/helloworld").request().get(String.class);
        assertEquals("Hello World!", hello);
    }
}
