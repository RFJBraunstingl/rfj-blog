package dev.rfj.blog.themeconfig;

import dev.rfj.blog.model.Theme;
import io.quarkus.qute.Template;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
class ThemeServiceImpl implements ThemeService {

    static final String DEFAULT_THEME_NAME = "default";

    private final Map<String, Theme> availableThemes = new HashMap<>();

    @ConfigProperty(name = "rfj-blog.theme")
    String nameOfActiveTheme;

    @Override
    public Theme getActiveTheme() {
        Theme theme = availableThemes.get(nameOfActiveTheme);
        if (theme != null)
            return theme;

        theme = availableThemes.get(DEFAULT_THEME_NAME);

        assert theme != null;

        return theme;
    }

    @Override
    public Template getBlogOverviewTemplate() {
        return getActiveTheme().getBlogOverviewTemplate();
    }

    void addAvailableTheme(String name, Theme theme) {
        availableThemes.put(name, theme);
    }

    // visible for testing
    Theme getThemeForName(String name) {
        return availableThemes.get(name);
    }
}
