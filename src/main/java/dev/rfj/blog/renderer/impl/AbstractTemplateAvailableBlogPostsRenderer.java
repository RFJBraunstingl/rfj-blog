package dev.rfj.blog.renderer.impl;

import dev.rfj.blog.renderer.AvailableBlogPostsRenderer;
import dev.rfj.blog.service.AvailableBlogPostService;
import io.quarkus.qute.Template;

abstract class AbstractTemplateAvailableBlogPostsRenderer implements AvailableBlogPostsRenderer {

    private Template template;
    private AvailableBlogPostService blogPostService;

    // dummy constructor for CDI
    AbstractTemplateAvailableBlogPostsRenderer() {}

    protected AbstractTemplateAvailableBlogPostsRenderer(Template template, AvailableBlogPostService blogPostService) {
        this.template = template;
        this.blogPostService = blogPostService;
    }

    @Override
    public String renderAvailableBlogPosts() {
        return template
                .data(
                        "blogPosts",
                        blogPostService.getAvailableBlogPosts()
                ).render();
    }
}
