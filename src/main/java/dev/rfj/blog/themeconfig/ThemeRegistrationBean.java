package dev.rfj.blog.themeconfig;

import dev.rfj.blog.model.Theme;
import io.quarkus.qute.Template;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.event.Observes;

abstract class ThemeRegistrationBean {

    abstract String getThemeName();
    abstract ThemeServiceImpl getThemeService();
    abstract Template getBlogOverViewTheme();

    void onStart(@Observes StartupEvent ev) {
        getThemeService().addAvailableTheme(
                getThemeName(),
                new Theme() {
                    @Override
                    public Template getBlogOverviewTemplate() {
                        return getBlogOverViewTheme();
                    }
                }
        );
    }
}
