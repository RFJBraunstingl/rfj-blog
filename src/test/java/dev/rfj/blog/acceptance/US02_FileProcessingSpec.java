package dev.rfj.blog.acceptance;

import org.junit.jupiter.api.Test;

/*
 * As an admin, I want text based files stored in a specific directory to be parsed to blog posts
 */
public class US02_FileProcessingSpec {

    /**
     * For the project, blog post files are stored under {PROJECT_ROOT}/pages/blog-posts/.
     * Speaking in terms of execution context for the running application, it will be the parent of the execution directory.
     * The <code>System</code> property called "user.dir" presents the path of the execution directory, '..' commonly
     * refers to the parent directory on all major OSes, thus the application shall pick up all files from the path:
     * 'System.getProperty("user.dir")/../'
     */
    @Test
    public void testFileProcessingSpec() {

    }
}
