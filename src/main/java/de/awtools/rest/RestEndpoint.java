package de.awtools.rest;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

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
    @Path("/helloworld")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWorld() {
        return "Hello World!";
    }

    @GET
    @Path("/markdown")
    @Produces(MediaType.TEXT_HTML)
    public String markdown() throws IOException {
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/de/awtools/markdown/markdown-example.md");
        Reader targetReader = new InputStreamReader(resourceAsStream);

        Parser parser = Parser.builder().build();
        Node document = parser.parseReader(targetReader);

        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document);  // "<p>This is <em>Sparta</em></p>\n"
    }

}
