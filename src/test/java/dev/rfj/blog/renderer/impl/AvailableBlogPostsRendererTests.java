package dev.rfj.blog.renderer.impl;

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
    private TemplateAvailableBlogPostsRenderer renderer;

    @Test
    public void testDefaultOutput() throws IOException {
        String expectedString = fullTrim(getTestResourceAsString("templates/defaultBlogOverviewParameterized.html"));
        String actualString = fullTrim(renderer.renderAvailableBlogPosts());
        Assertions.assertEquals(expectedString, actualString);
    }
}