package de.awtools.rest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

class MarkdownTest {

    @Test
    void markdown() {
        Parser parser = Parser.builder().build();
        Node document = parser.parse("This is *Sparta*");
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        String str = renderer.render(document);  // "<p>This is <em>Sparta</em></p>\n"
        
        assertThat(str).startsWith("<p>This is <em>Sparta</em></p>");
    }

}
