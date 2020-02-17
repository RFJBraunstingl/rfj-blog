package dev.rfj.blog.adapter.markdown;

import org.commonmark.Extension;
import org.commonmark.ext.autolink.AutolinkExtension;
import org.commonmark.ext.gfm.strikethrough.StrikethroughExtension;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import javax.enterprise.context.ApplicationScoped;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class CommonMarkMarkdownHtmlConversionAdapter implements MarkdownHtmlConversionAdapter {

    private static final List<Extension> EXTENSION = Arrays.asList(
            TablesExtension.create(),
            AutolinkExtension.create(),
            StrikethroughExtension.create()
    );

    @Override
    public String convertMarkdownToHtml(String markdown) {
        Parser parser = Parser.builder().extensions(EXTENSION).build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder().extensions(EXTENSION).build();
        return renderer.render(document);
    }
}
