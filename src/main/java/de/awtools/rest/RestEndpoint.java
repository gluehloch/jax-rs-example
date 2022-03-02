package de.awtools.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType; 

@Path("/notifications")
public class RestEndpoint {

    @GET
    @Path("/ping")
    public String getString() {
        return "string";
    }
    
}
