package dev.rfj.blog.acceptance;

import dev.rfj.blog.blogposts.retriever.BlogPostRetrievalService;
import dev.rfj.blog.model.BlogPost;
import dev.rfj.blog.testdata.MarkdownSyntaxReferenceAsHtml;
import dev.rfj.blog.util.TestUtil;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.swing.*;

import java.io.IOException;

import static dev.rfj.blog.util.StringUtils.fullTrim;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * As an admin, I want to write blog posts in markdown
 */
@QuarkusTest
public class US03_MarkdownSyntaxParsingSpec {

    private static final String NAME_OF_MARKDOWN_SYNTAX_REFERENCE_BLOG_POST = "markdown-syntax-reference";

    @Inject
    private BlogPostRetrievalService blogPostRetrievalService;

    /**
     * There is a prepared reference for markdown syntax stored as test data as
     * /pages/blog-posts/markdown-syntax-reference
     *
     * To check the proper syntax parsing, a reference of how we expect the html to look like is prepared in
     * test/resources/data/markdown-spec.html
     */
    @Test
    public void testSpec() throws IOException {
        String expectedHtml = TestUtil.getTestResourceAsString("data/markdown-spec.html");
        String actualText = findReferenceBlogPost().getText();

        expectedHtml = fullTrim(expectedHtml);
        actualText = fullTrim(actualText);

        assertEquals(expectedHtml, actualText);
    }

    private BlogPost findReferenceBlogPost() {
        for (BlogPost blogPost : blogPostRetrievalService.getAvailableBlogPosts()) {
            if (NAME_OF_MARKDOWN_SYNTAX_REFERENCE_BLOG_POST.equals(blogPost.getName()))
                return blogPost;
        }
        throw new IllegalStateException("No blog post with given name " + NAME_OF_MARKDOWN_SYNTAX_REFERENCE_BLOG_POST + " could be found!");
    }
}
