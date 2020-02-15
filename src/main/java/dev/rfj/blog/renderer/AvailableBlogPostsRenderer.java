package dev.rfj.blog.renderer;

import dev.rfj.blog.service.AvailableBlogPostService;

public interface AvailableBlogPostsRenderer {

    /**
     * Retrieves the available blog posts form the injected <code>Bean</code> of the interface
     * {@link AvailableBlogPostService} and transforms them into an HTML implementation
     *
     * @return
     *  An HTML representation of the available blog posts
     */
    String renderAvailableBlogPosts();
}