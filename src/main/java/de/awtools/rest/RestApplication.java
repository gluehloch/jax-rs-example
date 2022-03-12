package de.awtools.rest;

import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.core.Application;

public class RestApplication extends Application {

    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(RestEndpoint.class);
        return s;
    }

}
