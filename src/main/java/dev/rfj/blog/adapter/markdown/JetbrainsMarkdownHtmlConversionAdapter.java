package dev.rfj.blog.adapter.markdown;

import org.intellij.markdown.ast.ASTNode;
import org.intellij.markdown.flavours.MarkdownFlavourDescriptor;
import org.intellij.markdown.flavours.gfm.GFMFlavourDescriptor;
import org.intellij.markdown.html.HtmlGenerator;
import org.intellij.markdown.parser.MarkdownParser;

import javax.enterprise.context.ApplicationScoped;

public class JetbrainsMarkdownHtmlConversionAdapter implements MarkdownHtmlConversionAdapter {

    @Override
    public String convertMarkdownToHtml(String markdown) {
        MarkdownFlavourDescriptor flavourDescriptor = new GFMFlavourDescriptor();
        final ASTNode parsedTree = new MarkdownParser(flavourDescriptor).buildMarkdownTreeFromString(markdown);
        final String html = new HtmlGenerator(markdown, parsedTree, flavourDescriptor, false).generateHtml();
        return html;
    }
}
