package dev.rfj.blog.renderer.impl;

import dev.rfj.blog.renderer.AvailableBlogPostsRenderer;
import dev.rfj.blog.service.AvailableBlogPostService;
import io.quarkus.qute.Template;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.io.IOException;

import static dev.rfj.blog.util.StringUtils.fullTrim;
import static dev.rfj.blog.util.TestUtil.getTestResourceAsString;

@QuarkusTest
public class AvailableBlogPostsRendererTests {

    @Inject
    private Template blogOverview;
    @Inject
    private AvailableBlogPostService blogPostService;

    @Test
    public void testDefaultOutput() throws IOException {
        AvailableBlogPostsRenderer renderer = new TemplateAvailableBlogPostsRenderer(
                blogOverview,
                blogPostService
        );

        String expectedString = fullTrim(getTestResourceAsString("templates/defaultBlogOverviewParameterized.html"));
        String actualString = fullTrim(renderer.renderAvailableBlogPosts());
        Assertions.assertEquals(expectedString, actualString);
    }
}