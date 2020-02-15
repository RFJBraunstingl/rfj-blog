package dev.rfj.blog.renderer.impl;

import dev.rfj.blog.service.AvailableBlogPostService;
import io.quarkus.qute.Template;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
class DefaultAvailableBlogPostsRenderer extends AbstractTemplateAvailableBlogPostsRenderer {

    @Inject
    protected DefaultAvailableBlogPostsRenderer(
            final Template defaultBlogOverview,
            final AvailableBlogPostService blogPostService) {
        super(defaultBlogOverview, blogPostService);
    }
}
