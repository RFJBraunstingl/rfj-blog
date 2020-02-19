package dev.rfj.blog.themeconfig;

import dev.rfj.blog.model.Theme;
import io.quarkus.qute.Template;
import io.quarkus.qute.api.ResourcePath;
import io.quarkus.runtime.StartupEvent;
import lombok.NoArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import static dev.rfj.blog.themeconfig.ThemeServiceImpl.DEFAULT_THEME_NAME;

@ApplicationScoped
@NoArgsConstructor
class DefaultThemeRegistrationBean extends ThemeRegistrationBean {

    @Inject
    @ResourcePath("default/blog_overview.html")
    Template blogOverviewTemplate;
    @Inject
    ThemeServiceImpl themeService;

    @Override
    String getThemeName() {
        return DEFAULT_THEME_NAME;
    }

    @Override
    ThemeServiceImpl getThemeService() {
        return themeService;
    }

    @Override
    Template getBlogOverViewTheme() {
        return blogOverviewTemplate;
    }

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
