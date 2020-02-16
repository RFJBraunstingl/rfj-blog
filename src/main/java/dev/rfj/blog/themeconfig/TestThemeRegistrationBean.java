package dev.rfj.blog.themeconfig;

import io.quarkus.qute.Template;
import io.quarkus.qute.api.ResourcePath;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
class TestThemeRegistrationBean extends ThemeRegistrationBean {

    @Inject
    @ResourcePath("test/blog_overview.html")
    Template blogOverviewTemplate;
    @Inject
    ThemeServiceImpl themeService;

    @Override
    String getThemeName() {
        return "test";
    }

    @Override
    ThemeServiceImpl getThemeService() {
        return themeService;
    }

    @Override
    Template getBlogOverViewTheme() {
        return blogOverviewTemplate;
    }
}
