package dev.rfj.blog.renderer.impl;

import dev.rfj.blog.renderer.AvailableBlogPostsRenderer;
import dev.rfj.blog.service.AvailableBlogPostService;
import io.quarkus.qute.Engine;
import io.quarkus.qute.Template;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import static dev.rfj.blog.util.StringUtils.isNotBlank;

@ApplicationScoped
class TemplateAvailableBlogPostsRenderer implements AvailableBlogPostsRenderer {

    private Template template;
    private AvailableBlogPostService blogPostService;

    // dummy constructor for CDI
    //TemplateAvailableBlogPostsRenderer() {}

    TemplateAvailableBlogPostsRenderer(
            final String templatePath,
            final AvailableBlogPostService blogPostService) {
        this(buildTemplateForPath(templatePath), blogPostService);
    }

    private static Template buildTemplateForPath(String templatePath) {
        assert isNotBlank(templatePath);
        Engine engine = buildTemplateEngine();
        Template template = engine.parse(templatePath);
        return template;
    }

    private static Engine buildTemplateEngine() {
        return Engine
                .builder()
                .addDefaults()
                .build();
    }

    @Inject
    protected TemplateAvailableBlogPostsRenderer(
            final Template blogOverview,
            final AvailableBlogPostService blogPostService) {
        this.template = blogOverview;
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
