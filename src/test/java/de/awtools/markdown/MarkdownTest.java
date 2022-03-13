package de.awtools.markdown;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.junit.jupiter.api.Test;

class MarkdownTest {

    @Test
    void loadAndParseMarkdownFile() throws IOException {
        InputStream resourceAsStream = this.getClass().getResourceAsStream("markdown-example.md");
        Reader targetReader = new InputStreamReader(resourceAsStream);

        Parser parser = Parser.builder().build();
        Node document = parser.parseReader(targetReader);

        HtmlRenderer renderer = HtmlRenderer.builder().build();
        String str = renderer.render(document);  // "<p>This is <em>Sparta</em></p>\n"

        System.out.println(str);
    }

}
