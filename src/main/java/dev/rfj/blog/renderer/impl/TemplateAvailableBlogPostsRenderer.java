package dev.rfj.blog.renderer.impl;

import dev.rfj.blog.model.BlogPost;
import dev.rfj.blog.renderer.AvailableBlogPostsRenderer;
import dev.rfj.blog.blogposts.AvailableBlogPostService;
import dev.rfj.blog.themeconfig.ThemeService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
class TemplateAvailableBlogPostsRenderer implements AvailableBlogPostsRenderer {

    private AvailableBlogPostService blogPostService;
    private ThemeService themeService;

    // dummy constructor for CDI
    TemplateAvailableBlogPostsRenderer() {
    }

    @Inject
    TemplateAvailableBlogPostsRenderer(
            final AvailableBlogPostService blogPostService,
            final ThemeService themeService) {
        this.blogPostService = blogPostService;
        this.themeService = themeService;
    }

    @Override
    public String renderAvailableBlogPosts() {
        List<BlogPost> availableBlogPosts = blogPostService.getAvailableBlogPosts();
        return themeService.getBlogOverviewTemplate()
                .data(
                        "blogPosts",
                        availableBlogPosts
                ).render();
    }
}
