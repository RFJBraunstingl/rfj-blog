package dev.rfj.blog.themeconfig;

import dev.rfj.blog.model.Theme;
import io.quarkus.qute.Template;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
class ThemeServiceImpl implements ThemeService {

    static final String DEFAULT_THEME_NAME = "default";

    private final Map<String, Theme> availableThemes = new HashMap<>();

    @Inject
    @ConfigProperty(name = "rfj.blog.theme", defaultValue = DEFAULT_THEME_NAME)
    String nameOfActiveTheme;

    @Override
    public Theme getActiveTheme() {
        Theme theme = availableThemes.get(nameOfActiveTheme);

        assert theme != null;

        return theme;
    }

    void addAvailableTheme(String name, Theme theme) {
        availableThemes.put(name, theme);
    }

    // visible for testing
    Theme getThemeForName(String name) {
        return availableThemes.get(name);
    }
}
