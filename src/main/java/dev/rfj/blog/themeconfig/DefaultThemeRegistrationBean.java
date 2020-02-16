package dev.rfj.blog.themeconfig;

import dev.rfj.blog.model.Theme;
import io.quarkus.qute.Template;
import io.quarkus.qute.api.ResourcePath;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import static dev.rfj.blog.themeconfig.ThemeServiceImpl.DEFAULT_THEME_NAME;

@ApplicationScoped
class DefaultThemeRegistrationBean {

    @Inject
    @ResourcePath("templates/default/blog_overview.html")
    private Template blogOverviewTemplate;
    @Inject
    private ThemeServiceImpl themeService;

    DefaultThemeRegistrationBean() {}

    void onStart(@Observes StartupEvent ev) {
        themeService.addAvailableTheme(
                DEFAULT_THEME_NAME,
                new Theme() {
                    @Override
                    public Template getBlogOverviewTemplate() {
                        return blogOverviewTemplate;
                    }
                }
        );
    }
}
