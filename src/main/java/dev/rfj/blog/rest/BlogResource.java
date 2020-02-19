package dev.rfj.blog.rest;

import dev.rfj.blog.renderer.AvailableBlogPostsRenderer;
import lombok.NoArgsConstructor;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.TEXT_HTML;

@Path("/blog")
@NoArgsConstructor
public class BlogResource {

    private AvailableBlogPostsRenderer blogPostsRenderer;

    @Inject
    public BlogResource(
            final AvailableBlogPostsRenderer blogPostsRenderer) {
        this.blogPostsRenderer = blogPostsRenderer;
    }

    @GET
    @Produces(TEXT_HTML)
    public String getAvailableBlogPosts() {
        return blogPostsRenderer.renderAvailableBlogPosts();
    }
}
