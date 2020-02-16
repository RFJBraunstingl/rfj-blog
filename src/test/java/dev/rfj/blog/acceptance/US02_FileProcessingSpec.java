package dev.rfj.blog.acceptance;

import dev.rfj.blog.blogposts.retriever.BlogPostRetrievalService;
import dev.rfj.blog.model.BlogPost;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

import static dev.rfj.blog.util.CollectionUtils.isEmpty;
import static org.junit.jupiter.api.Assertions.*;

/*
 * As an admin, I want text based files stored in a specific directory to be parsed to blog posts
 */
@QuarkusTest
public class US02_FileProcessingSpec {

    private static final String TITLE_FILE_1 = "test-blog-post-one";
    private static final String TITLE_FILE_2 = "test-blog-post-two";
    private static final String CONTENT_FILE_1 = "It works!!";
    private static final String CONTENT_FILE_2 = "Hello world!";

    @Inject
    private BlogPostRetrievalService blogPostService;

    /**
     * For the project, blog post files are stored under {PROJECT_ROOT}/pages/blog-posts/.
     * Speaking in terms of execution context for the running application, it will be the parent of the execution directory.
     * We will create 2 files there and expect those files to be picked up as blog posts.
     */
    @Test
    public void testFileProcessingSpec() {
        List<BlogPost> blogPosts = blogPostService.getAvailableBlogPosts();

        assertNotNull(blogPosts);
        assertFalse(isEmpty(blogPosts));
        assertEquals(2, blogPosts.size());

        BlogPost blogPostOne = blogPosts.get(0);
        BlogPost blogPostTwo = blogPosts.get(1);

        assertEquals(TITLE_FILE_1, blogPostOne.getName());
        assertEquals(CONTENT_FILE_1, blogPostOne.getText());
        assertEquals(TITLE_FILE_2, blogPostTwo.getName());
        assertEquals(CONTENT_FILE_2, blogPostTwo.getText());
    }
}
