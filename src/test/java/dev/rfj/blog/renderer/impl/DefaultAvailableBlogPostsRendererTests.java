package dev.rfj.blog.renderer.impl;

import dev.rfj.blog.service.AvailableBlogPostService;
import dev.rfj.blog.util.TestUtil;
import io.quarkus.qute.Template;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.io.IOException;

@QuarkusTest
public class DefaultAvailableBlogPostsRendererTests {

    @Inject
    private Template defaultBlogOverview;
    @Inject
    private AvailableBlogPostService availableBlogPostService;

    @Test
    public void testDefaultOutput() throws IOException {
        DefaultAvailableBlogPostsRenderer renderer = new DefaultAvailableBlogPostsRenderer(
                defaultBlogOverview,
                availableBlogPostService
        );

        String expectedString = TestUtil.getTestResourceAsString("templates/defaultBlogOverviewParameterized.html");
        Assertions.assertEquals(renderer.renderAvailableBlogPosts(), expectedString);
    }
}