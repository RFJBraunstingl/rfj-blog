package dev.rfj.blog.acceptance;

import org.junit.jupiter.api.Test;

/*
 * As an admin, I want text based files stored in a specific directory to be parsed to blog posts
 */
public class US02_FileProcessingSpec {

    private static final String TITLE_FILE_1 = "test-blog-post-one";
    private static final String TITLE_FILE_2 = "test-blog-post-two";
    private static final String CONTENT_FILE_1 = "It works!!";
    private static final String CONTENT_FILE_2 = "Hello world!";

    /**
     * For the project, blog post files are stored under {PROJECT_ROOT}/pages/blog-posts/.
     * Speaking in terms of execution context for the running application, it will be the parent of the execution directory.
     * We will create 2 files there and expect those files to be picked up as blog posts.
     */
    @Test
    public void testFileProcessingSpec() {

    }
}
