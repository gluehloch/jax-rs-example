package de.awtools.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;

public class RestEndpointTest {

    private HttpServer server;
    private WebTarget target;
 
    @BeforeEach
    public void setUp() throws Exception {
        server = Main.startServer();
 
        Client c = ClientBuilder.newClient();
        target = c.target(Main.BASE_URI);
    }
 
    @AfterEach
    public void tearDown() throws Exception {
        server.stop();
    }
 
    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetIt() {
        String responseMsg = target.path("myresource").request().get(String.class);
        assertEquals("Got it!", responseMsg);
    }

}
