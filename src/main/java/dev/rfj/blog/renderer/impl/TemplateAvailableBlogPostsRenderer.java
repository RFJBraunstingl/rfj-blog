package dev.rfj.blog.renderer.impl;

import dev.rfj.blog.model.BlogPost;
import dev.rfj.blog.renderer.AvailableBlogPostsRenderer;
import dev.rfj.blog.blogposts.retriever.BlogPostRetrievalService;
import dev.rfj.blog.themeconfig.ThemeService;
import lombok.NoArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
@NoArgsConstructor
class TemplateAvailableBlogPostsRenderer implements AvailableBlogPostsRenderer {

    private BlogPostRetrievalService blogPostService;
    private ThemeService themeService;

    @Inject
    TemplateAvailableBlogPostsRenderer(
            final BlogPostRetrievalService blogPostService,
            final ThemeService themeService) {
        this.blogPostService = blogPostService;
        this.themeService = themeService;
    }

    @Override
    public String renderAvailableBlogPosts() {
        List<BlogPost> availableBlogPosts = blogPostService.getAvailableBlogPosts();
        return themeService.
                getActiveTheme()
                .getBlogOverviewTemplate()
                .data(
                        "blogPosts",
                        availableBlogPosts
                ).render();
    }
}
