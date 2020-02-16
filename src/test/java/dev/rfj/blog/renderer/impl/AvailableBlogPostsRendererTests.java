package dev.rfj.blog.renderer.impl;

import dev.rfj.blog.blogposts.retriever.BlogPostRetrievalService;
import dev.rfj.blog.mock.MockAvailableBlogPosts;
import dev.rfj.blog.themeconfig.ThemeService;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.inject.Inject;
import java.io.IOException;

import static dev.rfj.blog.util.StringUtils.fullTrim;
import static dev.rfj.blog.util.TestUtil.getTestResourceAsString;
import static org.mockito.Mockito.*;

@QuarkusTest
public class AvailableBlogPostsRendererTests {

    @Mock
    private BlogPostRetrievalService blogPostRetrievalService;
    @Mock
    private ThemeService themeService;
    @InjectMocks
    private TemplateAvailableBlogPostsRenderer renderer;
    @Inject
    private ThemeService realThemeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(blogPostRetrievalService.getAvailableBlogPosts())
                .thenReturn(MockAvailableBlogPosts.MOCKED_BLOG_POSTS);
        when(themeService.getActiveTheme())
                .thenReturn(realThemeService.getActiveTheme());
    }

    @Test
    public void testDefaultOutput() throws IOException {
        String expectedString = fullTrim(getTestResourceAsString("templates/defaultBlogOverviewParameterized.html"));
        String actualString = fullTrim(renderer.renderAvailableBlogPosts());
        Assertions.assertEquals(expectedString, actualString);
    }
}