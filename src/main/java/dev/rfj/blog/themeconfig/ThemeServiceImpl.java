package dev.rfj.blog.themeconfig;

import io.quarkus.qute.Template;
import io.quarkus.qute.api.ResourcePath;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
class ThemeServiceImpl implements ThemeService {

    @Inject
    @ResourcePath("test/blog_overview.html")
    private Template blogOverviewTemplate;

    @Override
    public Template getBlogOverviewTemplate() {
        return blogOverviewTemplate;
    }
}
