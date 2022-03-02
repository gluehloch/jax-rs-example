package de.awtools.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType; 

@Path("/notifications")
public class RestEndpoint {

    @GET
    @Path("/ping")
    @Produces(MediaType.APPLICATION_JSON)
    public String getString() {
        return "string";
    }
 
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/text")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

}
