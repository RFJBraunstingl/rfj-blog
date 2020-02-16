package dev.rfj.blog.acceptance;

import dev.rfj.blog.blogposts.retriever.BlogPostRetrievalService;
import dev.rfj.blog.model.BlogPost;
import dev.rfj.blog.testdata.TestBlogPosts;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static dev.rfj.blog.util.CollectionUtils.isEmpty;
import static org.junit.jupiter.api.Assertions.*;

/*
 * As an admin, I want text based files stored in a specific directory to be parsed to blog posts
 */
@QuarkusTest
public class US02_FileProcessingSpec {

    @Inject
    private BlogPostRetrievalService blogPostService;

    /**
     * For the project, blog post files are stored under {PROJECT_ROOT}/pages/blog-posts/.
     * Speaking in terms of execution context for the running application, it will be the parent of the execution directory.
     * We will create 2 files there and expect those files to be picked up as blog posts.
     */
    @Test
    public void testFileProcessingSpec() {
        List<BlogPost> expectedBlogPosts = TestBlogPosts.MOCKED_BLOG_POSTS;
        List<BlogPost> blogPosts = blogPostService.getAvailableBlogPosts();

        Collections.sort(expectedBlogPosts);
        Collections.sort(blogPosts);

        for (int i = 0; i < expectedBlogPosts.size(); i++) {
            BlogPost expected = expectedBlogPosts.get(i);
            BlogPost actual = blogPosts.get(i);

            assertEquals(expected.getName(), actual.getName());
            assertEquals(expected.getText(), actual.getText());
        }
    }
}
